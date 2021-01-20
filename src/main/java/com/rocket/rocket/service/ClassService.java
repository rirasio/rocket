package com.rocket.rocket.service;

import java.util.List;

import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;

public interface ClassService {

	public void create(ClassVO classVO);

	public ClassVO read(String class_num);

	public boolean update(ClassVO classVO);

	public boolean delete(String class_num);

	public int getTotal(Criteria cri);
	
	public List<ClassVO> getList(Criteria cri);

}
