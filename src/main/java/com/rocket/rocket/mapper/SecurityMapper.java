package com.rocket.rocket.mapper;


import com.rocket.rocket.domain.UsersVO;

//회원권한인증
public interface SecurityMapper {

	
	public UsersVO read(String userid);
	


}
