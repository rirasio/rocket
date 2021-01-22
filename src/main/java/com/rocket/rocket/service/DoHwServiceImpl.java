package com.rocket.rocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.DoHwVO;
import com.rocket.rocket.mapper.DoHwMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DoHwServiceImpl implements DoHwService {

	private DoHwMapper dohwMapper;

	@Override
	public void create(DoHwVO dohwvo) {
		dohwMapper.insert(dohwvo);
	}

	@Override
	public DoHwVO read(String dohw_num) {
		return dohwMapper.select(dohw_num);
	}

	@Override
	public boolean update(DoHwVO dohwvo) {
		return dohwMapper.update(dohwvo) == 1 ? true : false;
	}

	@Override
	public boolean delete(String dohw_num) {
		return dohwMapper.delete(dohw_num) == 1 ? true : false;
	}

	@Override
	public List<DoHwVO> readList(@RequestParam("hw_num") String hw_num, Criteria cri) {
		return dohwMapper.readList();
	}

	@Override
	public int getTotal(Criteria cri) {
		return dohwMapper.getTotalCount(cri);
	}

}
