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
	
	
	
	@Insert("insert into class values (num.nextval, #{title}, #{intro}, sysdate, sysdate, #{ctgy_title}, 'qqruqq@naver.com')")
	public void insertClass(ClassVO classVO);

	@Select("select * from class where num = #{num}")
	@ResultType(ClassVO.class)
	public ClassVO select(Long num);
	
	@Select("select * from class ctgy")
	@ResultType(CtgyVO.class)
	public CtgyVO selectCTGY();
	
	
	
	

	@Update("update class set title = #{title}, intro = #{intro} where num = #{num}")
	public int update(ClassVO classVO);

	@Delete("delete from class where num = #{num}")
	public int delete(Long num);

	@Select("select count(*) from class")
	@ResultType(Integer.class)
	public int getTotalCount(Criteria cri);

	@Select("select * from class")
	@ResultType(ClassVO.class)
	public List<ClassVO> getList();

}
