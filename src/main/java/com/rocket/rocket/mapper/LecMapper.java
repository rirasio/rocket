package com.rocket.rocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.LecVO;

public interface LecMapper {
	
	@Select("SELECT * FROM lec WHERE class_num = #{class_num} ORDER BY lorder")
	public List<LecVO> getList(Long class_num);
	
	@Select("select * from lec where num = #{num}")
	public LecVO select(Long num);
	
	@Insert("insert into lec values("
			+ " seq_lec.nextval, #{title}, #{video}, #{ingre},"
			+ " SYSDATE, null, '1', #{class_num}, #{lorder}"
			+ ")")
	public void insert(LecVO lecvo, Long class_num);
	
	@Delete("delete from lec where num = #{num}")
	public int delete(Long num);
	
	@Update("update lec set "
			+ "title= #{title}, video= #{video}, ingre= #{ingre}, modidate= SYSDATE, lorder= #{lorder} where num = #{num}")
	public int update(LecVO lecvo);
	
	@Update("update lec set clickcnt = clickcnt + 1 where num = #{num}")
	public int updateHitCount(Long num);
	
	
	

}
