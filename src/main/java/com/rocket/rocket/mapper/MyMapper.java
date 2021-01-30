package com.rocket.rocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.TakeDTO;
import com.rocket.rocket.domain.UserCtgyDTO;
import com.rocket.rocket.domain.UserRoleVO;
import com.rocket.rocket.domain.UsersVO;

public interface MyMapper {

	@Select("select * from users where email = #{email}")
	@ResultType(UsersVO.class)
	public UsersVO read(String email);

	@Update("update users set nickname = #{nickname}, birthday = #{birthday}, intro = #{intro}, mbti = #{mbti} where email = #{email}")
	public int update(UsersVO users);

	@Select("select * from user_role where email = #{email}")
	@ResultType(UserRoleVO.class)
	public List<UserRoleVO> myRole(String email);

	@Select("select c.ctgy_title, c.num, c.title, u.nickname, t.regdate from take t, class c, users u where t.class_num = c.num and c.email = u.email and t.email = #{email}")
	@ResultType(TakeDTO.class)
	public List<TakeDTO> myTake(String email);

	@Select("select uc.ctgy_title, cu.num, cu.title, cu.nickname from user_ctgy uc inner join (select * from class c inner join users u on c.email = u.email) cu on uc.ctgy_title = cu.ctgy_title where uc.email = #{email}")
	@ResultType(UserCtgyDTO.class)
	public List<UserCtgyDTO> myCtgy(String email);

	@Select("select * from class where email = #{email}")
	@ResultType(ClassVO.class)
	public List<ClassVO> myClass(String email);

	@Select("select avg(lec_sc_star) from lec_score where lec_num in (select num from lec where class_num = #{class_num})")
	public Double classAvg(long class_num);
}
