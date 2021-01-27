package com.rocket.rocket.service;

import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.ExVO;
import com.rocket.rocket.mapper.ExMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExServiceImpl implements ExService {

	private ExMapper exMapper;

	@Override
	public void create(ExVO ex) {
		exMapper.insert(ex);
	}

	@Override
	public ExVO read(long num) {
		return exMapper.select(num);
	}

	@Override
	public boolean update(ExVO ex) {
		return exMapper.update(ex) == 1 ? true : false;
	}

	@Override
	public boolean delete(long num) {
		return exMapper.delete(num) == 1 ? true : false;
	}

}
