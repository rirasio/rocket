package com.rocket.rocket.service;

import java.util.List;

import com.rocket.rocket.domain.SubVO;

public interface SubService {

	public void create(SubVO subvo);
	
	public SubVO read(String sub_num);
	
	public boolean update(SubVO subvo) ;
	
	public boolean delete(String sub_num);
	
	public List<SubVO> getList();
	
}
