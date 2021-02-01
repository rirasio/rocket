package com.rocket.rocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.UsersVO;
import com.rocket.rocket.mapper.TeacherMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {

	@Setter(onMethod_ = @Autowired)
	private TeacherMapper teacherMapper;

	
	@Override
	public UsersVO read(String name) {
		log.info("read............");
		return teacherMapper.select(name);
	}

	
	@Override
	public int getTotal(Criteria cri) {
		return teacherMapper.getTotalCount(cri);
	}
	
	@Override
	public List<UsersVO> teacherList() {
		
		log.info("get List !!!!!! ");
		return teacherMapper.classList();
	}

}
