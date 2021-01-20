package com.rocket.rocket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRoleVO {
	
	private String user_num;
	
	//이메일 확인용
	private String username;

	private byte user_role;
	

}
