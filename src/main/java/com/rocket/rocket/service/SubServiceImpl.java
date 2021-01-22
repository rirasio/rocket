package com.rocket.rocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rocket.rocket.domain.SubVO;
import com.rocket.rocket.mapper.SubMapper;

import lombok.Setter;

public class SubServiceImpl  implements SubService {

	@Setter(onMethod_ = @Autowired)
	private SubMapper mapper;
	
	@Override
	public void create(SubVO subvo) {
		mapper.insert(subvo);
	}

	@Override
	public SubVO read(String sub_num) {
		return mapper.select(sub_num);
	}

	@Override
	public boolean update(SubVO subvo) {
		return mapper.update(subvo) == 1;
	}

	@Override
	public boolean delete(String sub_num) {
		return mapper.delete(sub_num) == 1;
	}

	@Override
	public List<SubVO> getList() {
		return mapper.getList();
	}

}
