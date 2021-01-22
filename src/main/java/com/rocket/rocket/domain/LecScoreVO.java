package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class LecScoreVO {

	private int lec_sc_num;
	
	private Date lec_sc_date;
	
	private int lec_num;
	
	private int user_num;
	
	private int lec_sc_star;
}
