package com.rocket.rocket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayDto {

	private String pay_num;
	
	private Long payPrice;
	
	private String payDate;
	
	private String payExpire;
	
	private String sub_num;
	
	private String user_num;
}
