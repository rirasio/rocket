package com.rocket.rocket.service;

import java.util.List;

import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.CtgyVO;
import com.rocket.rocket.domain.UsersVO;

public interface TeacherService {


	
	public UsersVO read(String name);

	public int getTotal(Criteria cri);
	
	public List<UsersVO> teacherList();
	
	
	
	
	
}
