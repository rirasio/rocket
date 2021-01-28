package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.rocket.rocket.domain.TakeVO;
import com.rocket.rocket.domain.UserCtgyVO;
import com.rocket.rocket.domain.UsersVO;

public interface MyPageMapper {

	@Select("select * from users where email = #{email}")
	@ResultType(UsersVO.class)
	public UsersVO myPage(String email);

	@Select("select * from userctgy where email = #{email}")
	@ResultType(UserCtgyVO.class)
	public UserCtgyVO myCtgy(String email);

	@Select("select * from take where email = #{email}")
	@ResultType(TakeVO.class)
	public TakeVO myTake(String email);

}
