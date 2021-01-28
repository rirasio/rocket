package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.ExVO;

public interface ExMapper {

	@Insert("insert into ex values (seq_ex.nextval, #{title}, #{content}, #{answer}, sysdate, sysdate, #{lec_num})")
	public void insert(ExVO ex);

	@Select("select * from ex where num = #{num}")
	@ResultType(ExVO.class)
	public ExVO select(long num);

	@Update("update ex set title = #{title}, content = #{content}, answer = #{answer}, modidate = sysdate where num = #{num}")
	public int update(ExVO ex);

	@Delete("delete from ex where num = #{num}")
	public int delete(long num);

}
