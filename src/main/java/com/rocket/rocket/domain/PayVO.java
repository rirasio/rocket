package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PayVO {

	private Long num;
	
	private int payprice;
	
	private Date paydate;
	
	private Date payexpire;
	
	private Long sub_num;
	
	private String email;
}
