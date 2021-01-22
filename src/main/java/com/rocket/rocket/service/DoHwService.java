package com.rocket.rocket.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.DoHwVO;

public interface DoHwService {

	public void create(DoHwVO dohwvo);

	public DoHwVO read(String dohw_num);

	public boolean update(DoHwVO dohwvo);

	public boolean delete(String dohw_num);

	public List<DoHwVO> readList(@RequestParam("hw_num") String hw_num, Criteria cri);

	public int getTotal(Criteria cri);

}
