package com.rocket.rocket.service;

import java.util.List;

import com.rocket.rocket.domain.SubVO;

public interface SubService {

	public void create(SubVO subvo);
	
	public SubVO read(long num);
	
	public boolean update(SubVO subvo) ;
	
	public boolean delete(long num);
	
	public List<SubVO> getList();
	
}
