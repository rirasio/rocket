package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PayVO {

	private int pay_num;
	
	private Long payPrice;
	
	private Date payDate;
	
	private Date payExpire;
	
	private int sub_num;
	
	private int user_num;
}
