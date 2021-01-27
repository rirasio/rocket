package com.rocket.rocket.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.DoHwVO;

public interface DoHwService {

	public void create(DoHwVO dohwvo);

	public DoHwVO read(long num);

	public boolean update(DoHwVO dohwvo);

	public boolean delete(long num);

	public List<DoHwVO> readList(long hw_num, Criteria cri);

	public int getTotal(Criteria cri);

}
