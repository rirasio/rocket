package com.rocket.rocket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDto {

	private String notice_num;
	
	private String title;
	
	private String content;
	
	private String user_num;
	
	private String regDate;
	
	private String modiDate;
	
	private String delDate;
}
