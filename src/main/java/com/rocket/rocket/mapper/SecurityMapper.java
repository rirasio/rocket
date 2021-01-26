package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.rocket.rocket.domain.UsersVO;

//회원권한인증
@Mapper
public interface SecurityMapper {
	
	public UsersVO read(String userid);
	

}
