package com.rocket.rocket.service;

import java.util.List;

import com.rocket.rocket.domain.LecVO;

public interface LecService {
	
	public void create(LecVO lecvo);
	
	public LecVO read(Long num);
	
	public boolean update(LecVO lecvo);
	
	public boolean delete(Long num);
	
	public List<LecVO> getList(Long class_num);
	
	

}
