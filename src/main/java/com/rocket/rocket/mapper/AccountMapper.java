package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.rocket.rocket.domain.Account;

@Mapper
public interface AccountMapper {
	Account readAccount(String id);
}