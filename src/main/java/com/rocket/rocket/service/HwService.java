package com.rocket.rocket.service;

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.HwVO;

public interface HwService {

	public void create(HwVO hw);

	public HwVO read(long num);

	public boolean update(HwVO ex);

	public boolean delete(long num);

	public int getTotal(Criteria cri);

}
