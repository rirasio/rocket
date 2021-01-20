package com.rocket.rocket.service.lec;

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
	private LecMapper lecMapper;
	
	@Override
	public void register(LecVO lecvo) {
		lecMapper.insert(lecvo);
	}

}
