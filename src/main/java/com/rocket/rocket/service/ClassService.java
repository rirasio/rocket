package com.rocket.rocket.service;

import java.util.List;

import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.CtgyVO;

public interface ClassService {

	public void createClass(ClassVO classVO);
	
	public List<CtgyVO> ctgyList();
	
	public ClassVO read(Long num);

	public boolean update(ClassVO classVO);

	public boolean delete(Long num);

	public int getTotal(Criteria cri);

	
	public List<ClassVO> classList();


}
