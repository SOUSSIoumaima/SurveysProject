package com.horizon.surveyservice.service;


import com.horizon.surveyservice.entity.Answer;
import com.horizon.surveyservice.entity.Question;
import com.horizon.surveyservice.entity.Survey;
import com.horizon.surveyservice.repository.AnswerRepository;
import com.horizon.surveyservice.repository.QuestionRepository;
import com.horizon.surveyservice.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;


    public Survey createSurvey(Survey survey){
        return surveyRepository.save(survey);
    }


    public Survey getSurvey(long id){
        return surveyRepository.findById(id).orElse(null);
    }


    public List<Survey> getAllSurveys(){
        return surveyRepository.findAll();
    }


    public Question createQuestion(Question question){
        return questionRepository.save(question);
    }

    public Answer createAnswer(Answer answer){
        return answerRepository.save(answer);
    }

}
