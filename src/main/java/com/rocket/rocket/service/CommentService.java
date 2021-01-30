package com.rocket.rocket.service;

import java.util.List;

import com.rocket.rocket.domain.CommVO;

public interface CommentService {
	
	public void create(CommVO commvo);
	
	public CommVO read(Long num);
	
	public boolean update(CommVO commvo);
	
	public boolean delete(Long num);
	
	public List<CommVO> getList(Long class_num, Long lec_num);

}
