package com.rocket.rocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.UserRoleVO;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class SecurityService implements UserDetailsService {
	
	@Autowired
	SecurityRepository sercuritys;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("## loadUserByUsername ##");
		
		UserRoleVO userRole = sercuritys.findById(username);
		
		if( userRole == null ) {
			log.debug("## 계정정보가 존재하지 않습니다. ##");
			throw new UsernameNotFoundException(username);
		}
		return (UserDetails) userRole;
	}
}
