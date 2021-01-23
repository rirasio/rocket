package com.rocket.rocket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRoleVO {
	
	private byte auth_num;

	private String email;

}
