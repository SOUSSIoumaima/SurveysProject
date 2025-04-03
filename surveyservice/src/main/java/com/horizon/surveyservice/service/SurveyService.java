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

    // survey apis without update and lock
    public Survey createSurvey(Survey survey){
        return surveyRepository.save(survey);
    }
    public Survey getSurvey(long id){
        return surveyRepository.findById(id).orElse(null);
    }
    public List<Survey> getAllSurveys(){
        return surveyRepository.findAll();
    }
    public void deleteSurvey(long id){ surveyRepository.deleteById(id);}

    //question apis without update and lock
    public Question createQuestion(Question question){
        return questionRepository.save(question);
    }
    public Question getQuestion(long id){return questionRepository.findById(id).orElse(null);}
    public List<Question> getQuestionsBySurveyId(long surveyId) {return questionRepository.findBySurveyId(surveyId);}
    public void deleteQuestion(long id){ questionRepository.deleteById(id);}

    // answer apis without update and lock
    public Answer createAnswer(Answer answer){
        return answerRepository.save(answer);
    }
    public Answer getAnswer(long id){ return answerRepository.findById(id).orElse(null);}
    public List<Answer> getAnswerByQuestionId(long questionId) {return answerRepository.findByQuestionId(questionId);}
    public void deleteAnswer(long id){ answerRepository.deleteById(id);}



}
