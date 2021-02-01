package com.rocket.rocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.LecVO;
import com.rocket.rocket.mapper.LecMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class LecServiceImpl implements LecService {

	@Setter(onMethod_ = @Autowired)
	private LecMapper mapper;
	
	@Override
	public void create(LecVO lecvo) {
		mapper.insert(lecvo);
	}

	@Override
	public LecVO read(Long num) {
		mapper.updateHitCount(num);
		return mapper.select(num);
	}

	@Override
	public boolean update(LecVO lecvo) {
		return mapper.update(lecvo) == 1;
	}

	@Override
	public boolean delete(Long num) {
		return mapper.delete(num) == 1;
	}

	@Override
	public List<LecVO> getList(Long class_num) {
		return mapper.getList(class_num);
	}	

}
