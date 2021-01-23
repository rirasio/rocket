
package com.rocket.rocket.service;

import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.HwVO;

import com.rocket.rocket.mapper.HwMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HwServiceImpl implements HwService {

	private HwMapper hwMapper;

	@Override
	public void create(HwVO hwvo) {
		hwMapper.insert(hwvo);
	}

	@Override
	public HwVO read(long num) {
		return hwMapper.select(num);
	}

	@Override
	public boolean update(HwVO hwvo) {
		return hwMapper.update(hwvo) == 1 ? true : false;
	}

	@Override
	public boolean delete(long num) {
		return hwMapper.delete(num) == 1 ? true : false;
	}

	@Override
	public int getTotal(Criteria cri) {
		return hwMapper.getTotalCount(cri);
	}

}
