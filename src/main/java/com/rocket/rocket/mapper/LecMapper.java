package com.rocket.rocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.LecVO;

public interface LecMapper {
	
	@Select("SELECT num, lorder, title FROM lec WHERE class_num = 1 ORDER BY lorder")
	public List<LecVO> getList();
	
	@Select("select * from lec where num = #{num}")
	public LecVO select(String lec_num);
	
	@Insert("insert into lec values("
			+ " seq_lec.nextval, #{title}, #{video}, #{ingre},"
			+ " SYSDATE, SYSDATE, '1', 2, #{lorder}"
			+ ")")
	public void insert(LecVO lecvo);
	
	@Delete("delete from lec where num = #{num}")
	public int delete(String lec_num);
	
	@Update("update lec set "
			+ "title= #{title}, video= #{video}, ingre= #{ingre}, modiDate= SYSDATE, lorder= #{lorder} where num = #{num}")
	public int update(LecVO lecvo);
	
	@Update("update lec set clickcnt = clickcnt + 1 where num = #{num}")
	public int updateHitCount(String lec_num);
	
	
	

}
