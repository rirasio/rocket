package com.rocket.rocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.rocket.rocket.domain.Account;
import com.rocket.rocket.mapper.AccountMapper;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AccountRepository {

	@Autowired
	AccountMapper accountMapper;
	
	public Account findById(String username) {
		log.info("find id :: "+username);
		return accountMapper.readAccount(username);
	}
	
	public List<String>findauthoritiesbyid(String username){
		log.info("auth id :: "+username);
		return (List<String>)accountMapper.readAuthorites(username);
	}
}