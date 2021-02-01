package com.rocket.rocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.UsersVO;

public interface TeacherMapper {

	
	@Select("select u.* from users u, user_role r where u.email = r.email and name = #{name}")
	@ResultType(UsersVO.class)
	public UsersVO select(String name);

	@Select("select u.count(*) from users u, user_role r where u.email = r.email")
	@ResultType(Integer.class)
	public int getTotalCount(Criteria cri);

	@Select("select u.* from users u, user_role r where u.email = r.email and auth_num=2 ORDER by u.name")
	@ResultType(UsersVO.class)
	public List<UsersVO> classList();
	

}