package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class LecScoreVO {

	private Long num;
	
	private Date lec_sc_date;
	
	private Long lec_num;
	
	private Double lec_sc_star;
	
	private String email;
}
