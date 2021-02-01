package com.rocket.rocket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.PayVO;
import com.rocket.rocket.mapper.SubMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class PayServiceImpl implements PayService {

	
	@Override
	public void create(PayVO payvo) {
		
	}

	@Override
	public PayVO read(long num) {
		return null;
	}

	@Override
	public boolean update(PayVO subvo) {
		return false;
	}

	@Override
	public boolean delete(long num) {
		return false;
	}

	@Override
	public List<PayVO> getList() {
		return null;
	}

}
