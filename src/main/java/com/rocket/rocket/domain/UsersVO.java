package com.rocket.rocket.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class UsersVO {
	
	private String userid;
	
	private String password;
	
	private String name;
	
	private String nickname;
	
	private String birthday;
	
	private String phone;
	
	private boolean agree_e;
	
	private boolean agree_ue;
	
	private Date regdate;
	
	private Date deldate;
	
	private String intro;
	
	private String mbti;
	
	private boolean enabled;
	
	private List<UserRoleVO> authList;
	
	
	
}
