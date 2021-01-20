package com.rocket.rocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.mapper.ClassMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class ClassServiceImpl implements ClassService {

	@Setter(onMethod_ = @Autowired)
	private ClassMapper classMapper;

	@Override
	public void create(ClassVO classVO) {
		log.info("create............");
		classMapper.insert(classVO);
	}

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
	public List<ClassVO> getList(Criteria cri) {
		
		log.info("get List with criteria :: " + cri);
		return (List<ClassVO>) classMapper.getListWithPaging(cri);
	}

}
