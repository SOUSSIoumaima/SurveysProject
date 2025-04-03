package com.horizon.surveyservice.repository;

import com.horizon.surveyservice.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
    List<Answer> findByQuestionId(long questionId);
}
