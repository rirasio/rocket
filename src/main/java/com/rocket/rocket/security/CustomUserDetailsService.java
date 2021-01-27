package com.rocket.rocket.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rocket.rocket.domain.UsersVO;
import com.rocket.rocket.mapper.SecurityMapper;
import com.rocket.rocket.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@Service
public class CustomUserDetailsService implements UserDetailsService{

	//@Setter(onMethod_ = {@Autowired})
	@Autowired
	private  SecurityMapper securityMapper;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		Optional<UsersVO> opUsersvo = Optional.of(securityMapper.read(username));
//		UsersVO vo = opUsersvo.get();
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		log.warn("Load User By UserName : " + username);
		UsersVO vo = securityMapper.read(username);
		
		log.warn("qurried by users mapper : " + vo);
		
		if( vo == null ) {
			log.debug("## 계정정보가 존재하지 않습니다. ##");
			throw new UsernameNotFoundException(username);
		}
		
		
		return vo == null ? null : new CustomUser(vo);

	}

}
