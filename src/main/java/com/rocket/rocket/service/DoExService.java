package com.rocket.rocket.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.DoExDTO;
import com.rocket.rocket.domain.DoExVO;
import com.rocket.rocket.domain.DoHwDTO;
import com.rocket.rocket.domain.DoHwVO;

public interface DoExService {

	public void create(DoExVO dohw);

	public DoExDTO read(long num);

	public boolean update(DoExVO dohw);

	public boolean delete(long num);

	public List<DoExDTO> readList(long hw_num);



}
