package com.rocket.rocket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClassAvgScoreDTO {

	private String ctgy_title, title, intro;
	private long num;
	private double avgscore;

}
