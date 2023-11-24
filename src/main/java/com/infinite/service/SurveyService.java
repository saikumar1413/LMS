package com.infinite.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.infinite.model.SurveyPojo;

@Service //Responsible for database interactions
public interface SurveyService extends JpaRepository<SurveyPojo, Long> {

}
