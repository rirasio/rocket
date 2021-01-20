package com.rocket.rocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.LecVO;
import com.rocket.rocket.mapper.LecMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@Primary
@AllArgsConstructor
public class LecServiceImpl implements LecService {

	@Setter(onMethod_ = @Autowired)
	private LecMapper mapper;
	
	@Override
	public void register(LecVO lecvo) {
		mapper.insert(lecvo);
	}

	@Override
	public LecVO get(String lec_num) {
		mapper.updateHitCount(lec_num);
		return mapper.select(lec_num);
	}

	@Override
	public boolean modify(LecVO lecvo) {
		return mapper.update(lecvo) == 1;
	}

	@Override
	public boolean remove(String lec_num) {
		return mapper.delete(lec_num) == 1;
	}

	@Override
	public List<LecVO> getList() {
		return mapper.getList();
	}
	
	

}
