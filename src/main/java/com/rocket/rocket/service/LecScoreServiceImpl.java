package com.rocket.rocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.LecScoreVO;
import com.rocket.rocket.mapper.LecScoreMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class LecScoreServiceImpl implements LecScoreService {

	@Setter(onMethod_ = @Autowired)
	private LecScoreMapper mapper;
	
	@Override
	public void create(LecScoreVO lecscorevo) {

	}

}
