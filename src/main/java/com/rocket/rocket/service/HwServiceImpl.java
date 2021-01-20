package com.rocket.rocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.HwVO;

import com.rocket.rocket.mapper.HwMapper;


import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class HwServiceImpl implements HwService {

	@Setter(onMethod_ = @Autowired)
	private HwMapper hwMapper;

	@Override
	public void create(HwVO hwvo) {
		hwMapper.insert(hwvo);
	}

	@Override
	public HwVO read(String hw_Num) {
		return hwMapper.select(hw_Num);
	}

	@Override
	public boolean update(HwVO hwvo) {
		return hwMapper.update(hwvo) == 1 ? true : false;
	}

	@Override
	public boolean delete(String hw_Num) {
		return hwMapper.delete(hw_Num) == 1 ? true : false;
	}

	@Override
	public int getTotal(Criteria cri) {
		return hwMapper.getTotalCount(cri);
	}

}
