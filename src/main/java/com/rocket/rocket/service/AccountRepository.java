package com.rocket.rocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rocket.rocket.domain.Account;
import com.rocket.rocket.mapper.AccountMapper;

@Repository
public class AccountRepository {

	@Autowired
	AccountMapper accountMapper;

	public Account findById(String username) {
		return accountMapper.readAccount(username);
	}
}