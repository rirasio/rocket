package com.rocket.rocket.mapper.lec;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import com.rocket.rocket.domain.LecVO;

public interface LecMapper {
	
	@Insert("insert into lec values("
			+ "'lec_' || seq_lec.nextval, #{title}, #{video}, #{ingre},"
			+ " #{regDate}, #{modiDate}, #{clickCnt}, class_2, 6"
			+ ")")
	public List<LecVO> insert(LecVO lecvo);

}
