package com.rocket.rocket.service.lec;

import java.util.List;

import com.rocket.rocket.domain.LecVO;

public interface LecService {
	
	public void register(LecVO lecvo);
	
	public LecVO get(String lec_num);
	
	public boolean modify(LecVO lecvo);
	
	public boolean remove(String lec_num);
	
	public List<LecVO> getList();
	
	

}
