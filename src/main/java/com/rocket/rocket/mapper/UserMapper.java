package com.rocket.rocket.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.Criteria;

import com.rocket.rocket.domain.HwVO;
import com.rocket.rocket.domain.UsersVO;

public interface UserMapper {

	@Insert("insert into users(USER_NUM,EMAIL,PW,NAME,NICKNAME,BIRTHDAY,PHONE,AGREE_E,AGREE_UE,REGDATE,INTRO,PIC,PICTYPE,PICPATH)"
			+ " values ('users_' || seq_users.nextval, #{email}, #{pw}, #{name}, "
			+ "#{nickname}, #{birthday}, #{phone}, #{agree_e} ,#{agree_ue}, sysdate,#{intro},#{pic},#{picType},#{picPath})")
	public void insert(UsersVO usersvo);

	@Update("update users set NICKNAME = #{NICKNAME}, PHONE = #{PHONE}, PIC = #{pic}, "
			+ "picType = #{picType}, picPath = #{picPath}) where USER_NUM = #{USER_NUM}")
	public int update(UsersVO usersvo);

	@Insert("insert into users(DELDATE) values(sysdate) where users_Num = #{users_Num}")
	public int delete(String usersvo_Num);

}
