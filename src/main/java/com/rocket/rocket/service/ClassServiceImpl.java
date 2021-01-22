package com.rocket.rocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rocket.rocket.domain.ClassCtgyVO;
import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.MakeVO;
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
//		classMapper.insertClass_ctgy(classCtgyVO);
//		classMapper.insertMake(makeVO);
	}
	
//	@Override
//	public void createClassCtgy(ClassCtgyVO classCtgyVO) {
//		log.info("createClassCtgy............");
//		classMapper.insertClass_ctgy(classCtgyVO);
//	}
//	
//	@Override
//	public void createMake(MakeVO makeVO) {
//		log.info("createMake............");
//		classMapper.insertMake(makeVO);
//	}

	
	
	@Override
	public ClassVO read(String class_num) {
		log.info("read............");
		return classMapper.select(class_num);
	}

	@Override
	public boolean update(ClassVO classVO) {
		log.info("update............");
		return classMapper.update(classVO) == 1;
	}

	@Override
	public boolean delete(String class_num) {
		log.info("delete............");
		return classMapper.delete(class_num) == 1;
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
