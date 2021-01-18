package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PayVO {

	private String pay_num;
	
	private Long payPrice;
	
	private Date payDate;
	
	private Date payExpire;
	
	private String sub_num;
	
	private String user_num;
}
