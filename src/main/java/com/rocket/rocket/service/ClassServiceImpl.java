package com.rocket.rocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.mapper.ClassMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ClassServiceImpl implements ClassService {

	@Setter(onMethod_ = @Autowired)
	private ClassMapper classMapper;

	@Override
	public void createClass(ClassVO classVO) {
		log.info("createClass............");
		classMapper.insertClass(classVO);

	}
	


	
	
	@Override
	public ClassVO read(Long num) {
		log.info("read............");
		return classMapper.select(num);
	}

	@Override
	public boolean update(ClassVO classVO) {
		log.info("update............");
		return classMapper.update(classVO) == 1;
	}

	@Override
	public boolean delete(Long num) {
		log.info("delete............");
		return classMapper.delete(num) == 1;
	}

	@Override
	public int getTotal(Criteria cri) {
		return classMapper.getTotalCount(cri);
	}
	
	@Override
	public List<ClassVO> getList() {
		
		log.info("get List !!!!!! ");
		return classMapper.getList();
	}

}
