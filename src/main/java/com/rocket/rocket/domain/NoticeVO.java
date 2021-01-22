package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {

	private int notice_num;
	
	private String title;
	
	private String content;
	
	private int user_num;
	
	private Date regDate;
	
	private Date modiDate;
	
	private Date delDate;
}
