package com.rocket.rocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.CommVO;

public interface CommentMapper {

	@Select("SELECT * FROM comm WHERE class_num = #{class_num} AND lec_num = #{lec_num} ORDER BY num DESC")
	public List<CommVO> getList(@Param("class_num") Long class_num, @Param("lec_num") Long lec_num);
	
	@Insert("INSERT INTO comm VALUES (SEQ_COMM.nextval, #{nickname}, #{content}, SYSDATE, SYSDATE, null, '0', #{lec_num}, #{class_num}, #{email})")
	public void insert(CommVO commvo);
	
	@Select("")
	public CommVO select(Long num);
	
	@Delete("DELETE FROM comm WHERE num = #{num}")
	public int delete(Long num);
	
	@Update("UPDATE comm SET content = #{content}, modidate = SYSDATE WHERE num = #{num}")
	public int update(CommVO commvo);
	
}
