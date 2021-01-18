package com.rocket.rocket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRoleVO {
	
	private String user_num;
	
	private byte user_role;

}
