package com.rocket.rocket.service;

import com.rocket.rocket.domain.TakeVO;
import com.rocket.rocket.domain.UserCtgyVO;
import com.rocket.rocket.domain.UsersVO;

public interface MyPageService {

	public UsersVO myPage(String email);

	public UserCtgyVO myCtgy(String email);

	public TakeVO myTake(String email);
}
