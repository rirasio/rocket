package com.rocket.rocket.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rocket.rocket.domain.UsersVO;
import com.rocket.rocket.mapper.SecurityMapper;
import com.rocket.rocket.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	@Setter(onMethod_ = { @Autowired })
	private SecurityMapper securityMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.warn("Load User By UserName : " + username);
		UsersVO user = securityMapper.read(username);
		log.warn("queried by member mapper: " + user);

		return user == null ? null : new CustomUser(user);
//		return null;
	}

}
