package com.rocket.rocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.CtgyVO;

public interface ClassMapper {
	
	
	
	@Insert("insert into class values (seq_class.nextval, #{title}, #{intro}, sysdate, sysdate, #{ctgy_title}, 'qqruqq@naver.com')")
	public void insertClass(ClassVO classVO);


	@Select("select * from class where class_num = #{class_num}")
	@ResultType(ClassVO.class)
	public ClassVO select(Long num);
	
	@Select("select * from class ctgy")
	@ResultType(CtgyVO.class)
	public CtgyVO select();
	
	
	
	

	@Update("update class set title = #{title}, intro = #{intro} where class_num = #{class_num}")
	public int update(ClassVO classVO);

	@Delete("delete from class where class_num = #{class_num}")
	public int delete(Long num);

	@Select("select count(*) from class")
	@ResultType(Integer.class)
	public int getTotalCount(Criteria cri);

	@Select("select * from class")
	@ResultType(ClassVO.class)
	public List<ClassVO> getList();

}
