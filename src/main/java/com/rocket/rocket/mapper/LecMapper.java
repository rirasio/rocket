package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.rocket.rocket.domain.LecVO;

@Mapper
public interface LecMapper {
	
	public LecVO getLec();
	
	@Select("select title from lec")
	public LecVO getLecTitle();

}
