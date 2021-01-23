package com.rocket.rocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rocket.rocket.domain.UserRoleVO;
import com.rocket.rocket.mapper.SecurityMapper;

@Repository
public class SecurityRepository {

	@Autowired
	SecurityMapper securityMapper;
	
	public UserRoleVO findById(String username) {
		return securityMapper.readAccount(username);
		
	}
}
