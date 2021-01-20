package com.rocket.rocket.mapper.lec;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.LecVO;

public interface LecMapper {
	
	@Select("select * from lec order by lorder")
	public List<LecVO> getList();
	
	@Select("select * from lec where lec_num = #{lec_num}")
	public LecVO select(String lec_num);
	
	@Insert("insert into lec values("
			+ " 'lec_' || seq_lec.nextval, #{title}, #{video}, #{ingre},"
			+ " SYSDATE, SYSDATE, '1', 'class_2', #{lorder}"
			+ ")")
	public void insert(LecVO lecvo);
	
	@Delete("delete from lec where lec_num = #{lec_num}")
	public int delete(String lec_num);
	
	@Update("update lec set "
			+ "title= #{title}, video= #{video}, ingre= #{ingre}, modiDate= SYSDATE, lorder= #{lorder} where lec_num = #{lec_num}")
	public int update(LecVO lecvo);
	
	@Update("update lec set clickCnt = clickCnt + 1 where lec_num = #{lec_num}")
	public int updateHitCount(String lec_num);
	
	
	

}
