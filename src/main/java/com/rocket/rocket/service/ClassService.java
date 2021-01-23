package com.rocket.rocket.service;

import java.util.List;

import com.rocket.rocket.domain.ClassCtgyVO;
import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.MakeVO;

public interface ClassService {
	
	
	
	public void createClass(ClassVO classVO);
	public void createClassCtgy(ClassCtgyVO classCtgyVO);
	public void createMake(MakeVO makeVO);

	public ClassVO read(String class_num);

	public boolean update(ClassVO classVO);

	public boolean delete(String class_num);

	public int getTotal(Criteria cri);
	
	public List<ClassVO> getList();

}
