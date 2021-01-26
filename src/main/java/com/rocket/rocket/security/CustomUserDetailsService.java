package com.rocket.rocket.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.warn("Load User By UserName : " + username);
		UsersVO vo = securityMapper.read(username);
		
		log.warn("qurried by users mapper : " + vo);
		
		return vo == null ? null : new CustomUser(vo);
	}
	
	
	
}
