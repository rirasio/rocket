package com.rocket.rocket.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class UsersVO {
	
	private String email;
	
	private String pw;
	
	private String name;
	
	private String nickname;
	
	private String birthday;
	
	private String phone;
	
	private byte agree_e;
	
	private byte agree_ue;
	
	private Date regdate;
	
	private Date deldate;
	
	private String intro;
	
	private String mbti;
	
	private byte enabled;
	
	private List<UserRoleVO> authList;
	
}
