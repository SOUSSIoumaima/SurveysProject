package com.horizon.surveyservice.service;



import com.horizon.surveyservice.entity.Survey;
import com.horizon.surveyservice.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    // survey apis without update and lock
    public Survey createSurvey(Survey survey){
        return surveyRepository.save(survey);
    }
    public Survey getSurveyById(long id){
        return surveyRepository.findById(id).orElse(null);
    }
    public List<Survey> getAllSurveys(){
        return surveyRepository.findAll();
    }
    public void deleteSurvey(long id){
        if (!surveyRepository.existsById(id)) {
            throw new RuntimeException("Survey not found");
        }
        surveyRepository.deleteById(id);
    }
    public Survey updateSurvey(Long id, Survey survey){
        if (!surveyRepository.existsById(id)) {
            throw new RuntimeException("Survey not found");
        }
        return surveyRepository.save(survey);
    }
//    public Survey surveyLock(Long id, boolean locked){
//        Survey survey = surveyRepository.findById(id).orElseThrow(() -> new RuntimeException("Survey not found"));
//        survey.setLocked(locked);
//        return surveyRepository.save(survey);
//    }
//


}
