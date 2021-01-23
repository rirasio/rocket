package com.rocket.rocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.SubVO;
import com.rocket.rocket.mapper.ClassMapper;
import com.rocket.rocket.mapper.SubMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class SubServiceImpl  implements SubService {

	@Setter(onMethod_ = @Autowired)
	private SubMapper mapper;
	
	@Override
	public void create(SubVO subvo) {
		mapper.insert(subvo);
	}

	@Override
	public SubVO read(long num) {
		return mapper.select(num);
	}

	@Override
	public boolean update(SubVO subvo) {
		return mapper.update(subvo) == 1;
	}

	@Override
	public boolean delete(long num) {
		return mapper.delete(num) == 1;
	}

	@Override
	public List<SubVO> getList() {
		return mapper.getList();
	}

}
