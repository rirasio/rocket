package com.rocket.rocket.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.Account;

import lombok.extern.slf4j.Slf4j;

@Service
public class AccountService implements UserDetailsService{
	
	@Autowired
	AccountRepository accounts;
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account account = accounts.findById(username);
		log.info("## loadUserByUsername ##");
		
		if( account == null ) {
			log.debug("## 계정정보가 존재하지 않습니다. ##");
			throw new UsernameNotFoundException(username);
		}
		
		account.setAuthorities(getAuthorities(username));
		
		return account;
	}
	
	public Collection<GrantedAuthority> getAuthorities(String username) { 
		
		List<String> string_authorities = accounts.findauthoritiesbyid(username);
		
		log.info("권한값 from service :: " + string_authorities);
		
		if( string_authorities == null ) {
			log.info("## 해당 계정에 부여된 권한이 없습니다. ##");
			throw new UsernameNotFoundException(username);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
		
		for (String authority : string_authorities) { 
			authorities.add(new SimpleGrantedAuthority(authority)); 
		} 
		
		log.info("권한 담음 :: "+authorities.toString());
		
		return authorities; 

	}
}