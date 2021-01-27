package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.Criteria;

import com.rocket.rocket.domain.HwVO;

public interface HwMapper {

	@Insert("insert into hw values (seq_hw.nextval, #{title}, #{content}, #{lec_num})")
	public void insert(HwVO hwvo);

	@Select("select * from hw where num = #{num}")
	@ResultType(HwVO.class)
	public HwVO select(long num);

	@Update("update hw set title = #{title}, content = #{content} where num = #{num}")
	public int update(HwVO hwvo);

	@Delete("delete from hw where num = #{num}")
	public int delete(long num);

	@Select("select count(*) from hw")
	@ResultType(Integer.class)
	public int getTotalCount(Criteria cri);
}
