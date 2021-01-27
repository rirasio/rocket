package com.rocket.rocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.CommVO;
import com.rocket.rocket.mapper.CommentMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class CommentServicImpl implements CommentService {
	
	@Setter(onMethod_ = @Autowired)
	private CommentMapper mapper;

	@Override
	public void create(CommVO commvo) {
		mapper.insert(commvo);
	}

	@Override
	public CommVO read(Long num) {
		return mapper.select(num);
	}

	@Override
	public boolean update(CommVO commvo) {
		return mapper.update(commvo) == 1;
	}

	@Override
	public boolean delete(Long num) {
		return mapper.delete(num) == 1;
	}

	@Override
	public List<CommVO> getList(Long lec_num) {
		return mapper.getList(lec_num);
	}

}
