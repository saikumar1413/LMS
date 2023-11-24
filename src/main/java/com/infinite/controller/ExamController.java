package com.infinite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.model.Score;
import com.infinite.repository.ScoreRepository;

@RestController
@CrossOrigin("http://localhost:3000")//specify the allowed origin for connection
@RequestMapping("exam/s1")
public class ExamController {
  //constructor injection for automatic dependency injection
	@Autowired
	private ScoreRepository scorerepo;

	@PostMapping("/score")
	Score newUser(@RequestBody Score newUser) {
		return scorerepo.save(newUser);
	}
}
