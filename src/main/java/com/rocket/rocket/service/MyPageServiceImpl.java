package com.rocket.rocket.service;

import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.TakeVO;
import com.rocket.rocket.domain.UserCtgyVO;
import com.rocket.rocket.domain.UsersVO;
import com.rocket.rocket.mapper.MyPageMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyPageServiceImpl implements MyPageService {

	private MyPageMapper myPagemapper;

	@Override
	public UsersVO myPage(String email) {
		return myPagemapper.myPage(email);
	}

	@Override
	public UserCtgyVO myCtgy(String email) {
		return myPagemapper.myCtgy(email);
	}

	@Override
	public TakeVO myTake(String email) {
		return myPagemapper.myTake(email);
	}

}
