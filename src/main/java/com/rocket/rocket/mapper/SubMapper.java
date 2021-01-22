package com.rocket.rocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.SubVO;

public interface SubMapper {
	@Insert("insert into sub values ('sub_' || seq_sub.nextval, #{price}, #{type}, 1, 1, #{sub_num})")
	public void insert(SubVO subvo);


	@Select("select * from hw where sub_num = #{sub_num}")
	@ResultType(SubVO.class)
	public SubVO select(String sub_num);

	@Update("update hw set title = #{title}, content = #{content}, filename = 1, filetype = 1, filePath = 1, lec_num = #{lec_Num}")
	public int update(SubVO subvo);

	@Delete("delete from hw where hw_Num = #{hw_Num}")
	public int delete(String sub_Num);

	@Select("select * from sub order by price")
	public List<SubVO> getList();
}
