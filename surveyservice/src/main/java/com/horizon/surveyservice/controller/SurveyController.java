package com.horizon.surveyservice.controller;

import com.horizon.surveyservice.entity.Answer;
import com.horizon.surveyservice.entity.Question;
import com.horizon.surveyservice.entity.Survey;
import com.horizon.surveyservice.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;
    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey){
        return surveyService.createSurvey(survey);
    }
    @GetMapping("/{id}")
    public Survey getSurvey(@PathVariable Long id){
        return surveyService.getSurvey(id);
    }
    @GetMapping
    public List<Survey> getAllSurveys(){
        return surveyService.getAllSurveys();
    }
    @PostMapping("/{surveyId}/questions")
    public Question createQuestion(@PathVariable Long surveyId,@RequestBody Question question ){
        Survey survey = surveyService.getSurvey(surveyId);
        question.setSurvey(survey);
        return surveyService.createQuestion(question);
    }
    @PostMapping("/{surveyId}/questions/{questionId}/answers")
    public Answer createAnswer(@PathVariable Long surveyId,@PathVariable Long questionId,@RequestBody Answer answer){
        Question question = surveyService.getSurvey(surveyId).getQuestions().stream().filter(q -> q.getId().equals(questionId)).findFirst().orElse(null);
        answer.setQuestion(question);
        return surveyService.createAnswer(answer);
    }



}
