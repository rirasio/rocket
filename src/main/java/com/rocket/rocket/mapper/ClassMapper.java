package com.rocket.rocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.CtgyVO;

public interface ClassMapper {
	
	
	
	@Insert("insert into class values"
			+ "(seq_class.nextval, #{title}, #{intro}, sysdate, sysdate, #{ctgy_title}, 'qqruqq@naver.com')")
	public void insertClass(ClassVO classVO);

	@Select("select * from class where num = #{num}")
	@ResultType(ClassVO.class)
	public ClassVO select(Long num);
	
	@Select("select * from ctgy")
	@ResultType(CtgyVO.class)
	public List<CtgyVO> ctgyList();
	
	@Select("select MAX(NUM) from class")
	public Long maxNum();

	@Update("update class set title = #{title}, intro = #{intro}, modidate = sysdate where num = #{num}")
	public int update(ClassVO classVO);

	@Delete("delete from class where num = #{num}")
	public int delete(Long num);

	@Select("select count(*) from class")
	@ResultType(Integer.class)
	public int getTotalCount(Criteria cri);

	@Select("select * from class order by num")
	@ResultType(ClassVO.class)
	public List<ClassVO> classList();
	
	@Select("select * from class where ctgy_title=#{ctgy_title} order by num")
	@ResultType(ClassVO.class)
	public List<ClassVO> classListCTGY(String ctgy_title);

}