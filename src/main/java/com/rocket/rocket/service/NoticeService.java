package com.rocket.rocket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.NoticeVO;

import lombok.AllArgsConstructor;

@Service
public interface NoticeService {

	public void create(NoticeVO noticevo);
	
	public NoticeVO read(long num);
	
	public boolean update(NoticeVO noticevo) ;
	
	public boolean delete(long num);
	
	public List<NoticeVO> getList();
}
