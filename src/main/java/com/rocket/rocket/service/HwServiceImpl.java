package com.rocket.rocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.HwVO;

import lombok.AllArgsConstructor;
import lombok.Setter;
import mapper.HwMapper;

@Service
@AllArgsConstructor
public class HwServiceImpl implements HwService {

	@Setter(onMethod_ = @Autowired)
	private HwMapper hwMapper;

	@Override
	public void register(HwVO hwvo) {
		hwMapper.insert(hwvo);
	}

}
