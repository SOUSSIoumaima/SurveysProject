package com.horizon.surveyservice.controller;

import com.horizon.surveyservice.entity.Answer;
import com.horizon.surveyservice.entity.Question;
import com.horizon.surveyservice.entity.Survey;
import com.horizon.surveyservice.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;
    @PostMapping
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey){
        return ResponseEntity.status(201).body(surveyService.createSurvey(survey));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long id){
        Survey survey = surveyService.getSurveyById(id);
        if (survey != null) {
            return ResponseEntity.ok(survey);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public List<Survey> getAllSurveys(){

        return surveyService.getAllSurveys();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Long id, @RequestBody Survey survey){
        return ResponseEntity.ok(surveyService.updateSurvey(id, survey));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id){
        surveyService.deleteSurvey(id);
        return ResponseEntity.ok().build();
    }



}
