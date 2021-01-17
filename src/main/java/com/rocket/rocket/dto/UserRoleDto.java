package com.rocket.rocket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleDto {
	
	private String user_num;
	
	private String user_role;

	public String getUser_num() {
		return user_num;
	}

}
