package com.rocket.rocket.service;

import java.util.List;

import com.rocket.rocket.domain.PayVO;


public interface PayService {

	public void create(PayVO payvo);
	
	public PayVO read(long num);
	
	public boolean update(PayVO subvo) ;
	
	public boolean delete(long num);
	
	public List<PayVO> getList();
	
}
