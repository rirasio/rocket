package com.rocket.rocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.SubVO;

public interface SubMapper {
	@Insert("insert into sub values (seq_sub.nextval, #{price}, #{type}, 1, 1, #{num})")
	public void insert(SubVO subvo);


	@Select("select * from sub where sub_num = #{sub_num}")
	@ResultType(SubVO.class)
	public SubVO select(long num);

	@Update("update sub set title = #{title}, content = #{content} where num = #{num}")
	public int update(SubVO subvo);

	@Delete("delete from sub where num = #{num}")
	public int delete(long num);

	@Select("select * from sub order by price")
	public List<SubVO> getList();
}
