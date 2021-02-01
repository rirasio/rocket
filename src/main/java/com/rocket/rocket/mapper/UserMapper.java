package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.Account;
import com.rocket.rocket.domain.AccountRole;
import com.rocket.rocket.domain.Criteria;

import com.rocket.rocket.domain.HwVO;
import com.rocket.rocket.domain.UserRoleVO;

import com.rocket.rocket.domain.UsersVO;

public interface UserMapper {

	//하드코딩용
//	@Insert("insert into users(EMAIL,PW, NAME,NICKNAME,BIRTHDAY,PHONE,AGREE_E,AGREE_UE,REGDATE,INTRO)"
//			+ " values (#{email}, #{pw}, #{name}, "
//			+ "#{nickname}, #{birthday}, #{phone}, #{agree_e} ,#{agree_ue}, sysdate,#{intro})")
//	public void insert(UsersVO usersvo);

//	@Insert("insert into user_role(auth_num, email) values(#{auth_num}, #{email})")
//	public void insert2(UserRoleVO userrolevo);
	
	//jdbc테스트중
	@Insert("insert into users2(id, password, NAME,NICKNAME,BIRTHDAY,PHONE,AGREE_E,AGREE_UE,REGDATE,INTRO,isAccountNonExpired,isAccountNonLocked,isCredentialsNonExpired,isEnabled)"
			+ " values (#{id}, #{password}, #{name}, "
			+ "#{nickname}, #{birthday}, #{phone}, #{agree_e} ,#{agree_ue}, sysdate,#{intro},1,1,1,1)")
	public void insert(Account account);

	@Insert("insert into user_role2(username, authority_name) values(#{id}, #{authority_name})")
	public void insert2(AccountRole accountrole);

	@Update("update users set NICKNAME = #{NICKNAME}, PHONE = #{PHONE} " + " where email = #{email}")
	public int update(UsersVO usersvo);

	@Update("update users set NICKNAME = #{NICKNAME}, PHONE = #{PHONE}" + " where email = #{email}")
	public int update2(UsersVO usersvo);

	@Insert("insert into users(DELDATE) values(sysdate) where email = #{email}")
	public int delete(String email);

}
