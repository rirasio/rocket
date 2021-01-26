package com.rocket.rocket.service;

import com.rocket.rocket.domain.UserRoleVO;
import com.rocket.rocket.domain.UsersVO;

public interface UserService {

	public void create(UsersVO usersvo, UserRoleVO userrolevo);
	
	public boolean update(UsersVO uservo, UserRoleVO userrolevo);

	public boolean delete(String email);


}
