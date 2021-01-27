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
	
//	@Override
//	public void autoCreate(LecVO lecvo) {
//		for (int i=7; i<13; i++) {
//			for (int k=0; k<12; k++) {
//				lecvo.setClass_num((long) i);
//				lecvo.setNum((long) k);
//				lecvo.setTitle("제목"+k);
//				lecvo.setVideo("source"+k);
//				lecvo.setIngre("내용"+k);
//				lecvo.setLorder(k);
//				mapper.insert(lecvo);
//			}
//		}
//	}
	
	

}
