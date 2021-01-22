
package com.rocket.rocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.HwVO;
import com.rocket.rocket.domain.UsersVO;
import com.rocket.rocket.mapper.HwMapper;
import com.rocket.rocket.mapper.UserMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Setter(onMethod_ = @Autowired)
	private UserMapper userMapper;

	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;
	
	@Transactional
	@Override
	public void create(UsersVO usersvo) {
		usersvo.setPw(pwencoder.encode("pw"));
		userMapper.insert(usersvo);
	}

	@Transactional
	@Override
	public boolean update(UsersVO usersvo) {
		usersvo.setPw(pwencoder.encode("pw"));
		return userMapper.update(usersvo) == 1 ? true : false;
	}

	@Transactional
	@Override
	public boolean delete(String users_Num) {
		return userMapper.delete(users_Num) == 1 ? true : false;
	}

}
