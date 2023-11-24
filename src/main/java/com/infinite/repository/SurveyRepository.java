package com.infinite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinite.model.SurveyPojo;

@Repository //Responsible for database interactions
public interface SurveyRepository extends JpaRepository<SurveyPojo, Long> {

}
