package com.horizon.surveyservice.repository;

import com.horizon.surveyservice.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey,Long> {
}
