package com.infinite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.exceptions.UserNotFoundException;
import com.infinite.model.SurveyPojo;
import com.infinite.repository.SurveyRepository;

@RestController
@CrossOrigin("http://localhost:3000")//specify the allowed origin for connection
@RequestMapping("sur/v1")
public class SurveyController {
	//constructor injection for automatic dependency injection
	@Autowired
	private SurveyRepository surveyrepo;
	
 //Handles the POST request and returns a response
	@PostMapping("/survey")
	SurveyPojo newSurvey(@RequestBody SurveyPojo newSurvey) {
		return surveyrepo.save(newSurvey);
	}

	@GetMapping("/surveys")
	List<SurveyPojo> getAllUsers() {
		return surveyrepo.findAll();
	}
//Maps GET requests
	@GetMapping("/survey/{id}")
	SurveyPojo getUserById(@PathVariable Long id) {
		return surveyrepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
//Handles PUT requests for updating an item
	@PutMapping("/survey/{id}")
	SurveyPojo updateUser(@RequestBody SurveyPojo newUser, @PathVariable Long id) {
		return surveyrepo.findById(id).map(user -> {
			user.setUsername(newUser.getUsername());
			user.setEmail(newUser.getEmail());
			user.setProfession(newUser.getProfession());
			user.setInterest(newUser.getInterest());
			user.setDomain(newUser.getDomain());
			return surveyrepo.save(user);
		}).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	//Handles DELETE requests for updating an item
	@DeleteMapping("/survey/{id}")
	String deleteUser(@PathVariable Long id) {
		if (!surveyrepo.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		surveyrepo.deleteById(id);
		return "User with id " + id + " has been deleted success.";
	}

}
