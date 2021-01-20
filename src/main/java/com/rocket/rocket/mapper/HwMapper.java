package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.Insert;

import com.rocket.rocket.domain.HwVO;

public interface HwMapper {

	@Insert("insert into hw values ('hw_' || seq_hw.nextval, #{title}, #{content}, 1, 1, 1, #{lec_num})")
	public void insert(HwVO hwvo);
}
