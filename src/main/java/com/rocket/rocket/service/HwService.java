package com.rocket.rocket.service;

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.HwVO;

public interface HwService {

	public void create(HwVO hwvo);

	public HwVO read(String hw_Num);

	public boolean update(HwVO hwvo);

	public boolean delete(String hw_Num);

	public int getTotal(Criteria cri);

}