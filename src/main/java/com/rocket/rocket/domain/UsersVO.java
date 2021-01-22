package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class UsersVO {

	private int user_num;
	
	private String email;
	
	private String pw;
	
	private String name;
	
	private String nickname;
	
	private Date birthday;
	
	private String phone;
	
	private byte agree_e;
	
	private byte agree_ue;
	
	private Date regDate;
	
	private Date delDate;
	
	private String intro;
	
	private String mbti;
	
	private String pic;
	
	private byte picType;
	
	private String picPath;
	
}
