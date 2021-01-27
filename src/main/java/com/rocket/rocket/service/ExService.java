package com.rocket.rocket.service;

import com.rocket.rocket.domain.ExVO;

public interface ExService {

	public void create(ExVO ex);

	public ExVO read(long num);

	public boolean update(ExVO ex);

	public boolean delete(long num);

}
