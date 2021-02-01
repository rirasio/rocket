package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.Insert;

import com.rocket.rocket.domain.LecScoreVO;

public interface LecScoreMapper {

	@Insert("INSERT INTO lec_score VALUES (SEQ_LEC_SCORE.nextval, SYSDATE, #{lec_num}, #{lec_sc_star}, #{email})")
	public void insert(LecScoreVO lecscorevo);
}
