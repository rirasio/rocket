package com.rocket.rocket.security;

import javax.security.auth.login.AccountExpiredException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.rocket.rocket.domain.Account;
import com.rocket.rocket.service.AccountService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	
	@Autowired
//	private AccountService accountService;
	private AccountService accountService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		log.info("### authenticate ### ");

		String username =  authentication.getName();
//		String username =  (String) authentication.getPrincipal();
//		String password = (String) authentication.getCredentials();
//		String password = (String) authentication.getCredentials().toString();
		String password = (String) passwordEncoder.encode(authentication.getCredentials().toString());
		
		Account account = (Account) accountService.loadUserByUsername(username);
		
		// 검증.
		if ( !passwordEncoder.matches(password,account.getPassword())) {
			log.info("authprovider password ::: "+ password);
			log.info("가져오는 password ::: "+ account.getPassword());
			log.info("아이디 혹은 패스워드불일치");
			throw new BadCredentialsException(username);
		}else if(!account.isEnabled()) { // 계정 활성화여부 확인
			log.info("계정비활성화");
			throw new DisabledException(username);
		}else if(!account.isAccountNonExpired()) { // 계정 만료확인
			log.info("계정만료");
			//throw new AccountExpiredException(username);
		}else if(!account.isAccountNonLocked()) { // 계정 잠김확인
			log.info("계정잠김");
			throw new LockedException(username);
		}else if(!account.isCredentialsNonExpired()) { // 자격 만료확인
			log.info("자격만료");
			throw new CredentialsExpiredException(username); 
		}

		return new UsernamePasswordAuthenticationToken(username, password, account.getAuthorities());
	}


	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}


}
