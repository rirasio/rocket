package com.rocket.rocket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rocket.rocket.domain.ClassAvgScoreDTO;
import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.TakeDTO;

import com.rocket.rocket.domain.UserCtgyDTO;

import com.rocket.rocket.domain.UserRoleVO;
import com.rocket.rocket.domain.UsersVO;
import com.rocket.rocket.mapper.MyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MyServiceImpl implements MyService {

	private MyMapper myMapper;

	public List<ClassAvgScoreDTO> casList = null;

	public List<ClassVO> classvo = null;

	@Override
	public UsersVO read(String email) {
		return myMapper.read(email);
	}

	@Override
	public boolean update(UsersVO users) {
		return myMapper.update(users) == 1 ? true : false;
	}

	@Override
	public List<UserRoleVO> myRole(String email) {
		return myMapper.myRole(email);
	}

	@Override
	public List<TakeDTO> myTake(String email) {
		return myMapper.myTake(email);
	}

	@Override
	public List<UserCtgyDTO> myCtgy(String email) {
		return myMapper.myCtgy(email);
	}

	@Override
	public List<ClassAvgScoreDTO> myClass(String email) {

		classvo = myMapper.myClass(email);

		double avgscore;

		for (int i = 0; i < casList.size(); i++) {
			casList.remove(i);
		}

		for (ClassVO vo : classvo) {

			log.info(vo.getNum().toString());
			if (myMapper.classAvg(vo.getNum()) == null) {
				avgscore = 5;
			} else {
				avgscore = Math.round(myMapper.classAvg(vo.getNum()) * 100) / 100.0;
			}

			ClassAvgScoreDTO cas = new ClassAvgScoreDTO(vo.getCtgy_title(), vo.getTitle(), vo.getIntro(), vo.getNum(),
					avgscore);
			log.info(cas.toString());

			casList.add(cas);
		}

		log.info("casList: " + casList.toString());
		return casList;
	}

}
