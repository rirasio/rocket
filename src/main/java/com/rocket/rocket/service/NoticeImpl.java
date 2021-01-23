package com.rocket.rocket.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.NoticeVO;
import com.rocket.rocket.mapper.NoticeMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@AllArgsConstructor
@Slf4j
@Service
public class NoticeImpl implements NoticeService {

	private NoticeMapper mapper;
	
	@Override
	public void create(NoticeVO noticevo) {
		log.info("void create ,,,");
		mapper.insert(noticevo);
	}

	@Override
	public NoticeVO read(long num) {
		return mapper.select(num);
	}

	@Override
	public boolean update(NoticeVO noticevo) {
		return mapper.update(noticevo) == 1 ? true : false;
	}

	@Override
	public boolean delete(long num) {
		return mapper.delete(num) ==1 ? true : false;
	}

	@Override
	public List<NoticeVO> getList() {
		return mapper.getList();
	}
   
}
