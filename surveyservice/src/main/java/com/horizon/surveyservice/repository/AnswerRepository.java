package com.horizon.surveyservice.repository;

import com.horizon.surveyservice.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
