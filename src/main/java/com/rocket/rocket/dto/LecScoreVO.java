package com.rocket.rocket.dto;

import java.util.Date;

import lombok.Data;

@Data
public class LecScoreVO {

	private String lec_sc_num;
	
	private Date lec_sc_date;
	
	private String lec_num;
	
	private String user_num;
	
	private int lec_sc_star;
}
