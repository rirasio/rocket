package com.rocket.rocket.service;

import java.util.List;

import com.rocket.rocket.domain.NoticeVO;

public interface NoticeService {

	public void create(NoticeVO noticevo);
	
	public NoticeVO read(long num);
	
	public boolean update(NoticeVO noticevo) ;
	
	public boolean delete(long num);
	
	public List<NoticeVO> getList(String email);

	public List<NoticeVO> getListbyNickname(String nickname);
	
}
