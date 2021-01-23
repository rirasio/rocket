package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.rocket.rocket.domain.UserRoleVO;

//회원권한인증
@Mapper
public interface SecurityMapper {
	
	@ResultType(UserRoleVO.class)
	@Select("SELECT * FROM USERROLE WHERE ID= #{id}")
	public UserRoleVO readAccount(String email);
	

}
