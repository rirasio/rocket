package com.rocket.rocket.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class DoHwDTO {

	private Long num;

	private Date regdate;

	private Date modidate;

	private Long hw_num;

	private String email;
	
	private String nickname;
}
