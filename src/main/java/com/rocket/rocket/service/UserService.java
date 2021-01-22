package com.rocket.rocket.service;

import com.rocket.rocket.domain.UsersVO;

public interface UserService {

	public void create(UsersVO usersvo);
	
	public boolean update(UsersVO uservo);

	public boolean delete(String users_Num);


}
