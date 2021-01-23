package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.Criteria;

import com.rocket.rocket.domain.HwVO;

public interface HwMapper {

	@Insert("insert into hw values ('hw_' || seq_hw.nextval, #{title}, #{content}, 1, 1, 1, #{lec_Num})")
	public void insert(HwVO hwvo);

	@Select("select * from hw where hw_num = #{hw_Num}")
	@ResultType(HwVO.class)
	public HwVO select(String hw_num);

	@Update("update hw set title = #{title}, content = #{content}, filename = 1, filetype = 1, filePath = 1, lec_num = #{lec_Num} where hw_num = #{hw_Num}")
	public int update(HwVO hwvo);

	@Delete("delete from hw where hw_Num = #{hw_Num}")
	public int delete(String hw_Num);

	@Select("select count(*) from hw")
	@ResultType(Integer.class)
	public int getTotalCount(Criteria cri);
}
