package com.rocket.rocket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.DoExDTO;
import com.rocket.rocket.domain.DoExVO;
import com.rocket.rocket.mapper.DoExMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DoExServiceImpl implements DoExService {

	private DoExMapper doexMapper;

	@Override
	public void create(DoExVO dohw) {
		doexMapper.insert(dohw);
	}

	@Override
	public DoExDTO read(long num) {
		return doexMapper.select(num);
	}

	@Override
	public boolean update(DoExVO doex) {
		return doexMapper.update(doex) == 1 ? true : false;
	}

	@Override
	public boolean delete(long num) {
		return doexMapper.delete(num) == 1 ? true : false;
	}

	@Override
	public List<DoExDTO> readList(long ex_num) {
		return doexMapper.readList(ex_num);
	}

}
