package com.rocket.rocket.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class TakeDTO {

	private String ctgy_title;

	private int num;
	
	private String title, nickname;
	
	private Date regdate;
}
