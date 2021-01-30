package com.rocket.rocket.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocket.rocket.domain.CommVO;
import com.rocket.rocket.service.CommentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {
	
	private final CommentService service;
	
	@GetMapping("/all/{class_num}/{lec_num}")
	public ResponseEntity<List<CommVO>> list(@PathVariable("class_num") Long class_num, @PathVariable("lec_num") Long lec_num) {
		ResponseEntity<List<CommVO>> entity = null;
		try {
			entity = new ResponseEntity<List<CommVO>>(service.getList(class_num, lec_num), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<CommVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}
