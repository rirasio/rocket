package com.rocket.rocket.domain;

import lombok.Data;

/*
 * 회원구분
 * 
 * 0: 일반회원
 * 1: 구독회원
 * 2: 선생님
 * 9: 관리자
 * 
 * */

@Data
public class RoleVO {

	private byte role_num;
	
	private String roleName;
}
