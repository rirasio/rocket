package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.UsersVO;

public interface UserMapper {

	@Insert("insert into users(EMAIL,PW,NAME,NICKNAME,BIRTHDAY,PHONE,AGREE_E,AGREE_UE,REGDATE,INTRO)"
			+ " values (#{email}, #{pw}, #{name}, #{nickname}, #{birthday}, #{phone}, #{agree_e} ,#{agree_ue}, sysdate, #{intro})")
	public void insert(UsersVO usersvo);

	@Update("update users set NICKNAME = #{NICKNAME}, PHONE = #{PHONE}, PIC = #{pic}, "
			+ "picType = #{picType}, picPath = #{picPath}) where email = #{email}")
	public int update(UsersVO usersvo);

	@Insert("insert into users(DELDATE) values(sysdate) where email = #{email}")
	public int delete(String usersvo_Num);

}
