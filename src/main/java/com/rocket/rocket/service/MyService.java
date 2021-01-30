package com.rocket.rocket.service;

import java.util.List;

import com.rocket.rocket.domain.ClassAvgScoreDTO;
import com.rocket.rocket.domain.TakeDTO;
import com.rocket.rocket.domain.UserCtgyDTO;
import com.rocket.rocket.domain.UserRoleVO;
import com.rocket.rocket.domain.UsersVO;

public interface MyService {

	public UsersVO read(String email);

	public boolean update(UsersVO users);

	public List<UserRoleVO> myRole(String email);

	public List<TakeDTO> myTake(String email);

	public List<UserCtgyDTO> myCtgy(String email);

	public List<ClassAvgScoreDTO> myClass(String email);

}
