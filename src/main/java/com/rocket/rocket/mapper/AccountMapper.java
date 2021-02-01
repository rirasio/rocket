package com.rocket.rocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.rocket.rocket.domain.Account;

@Mapper
public interface AccountMapper {

	Account readAccount(String id);

	List<String> readAuthorites(String username);

}
