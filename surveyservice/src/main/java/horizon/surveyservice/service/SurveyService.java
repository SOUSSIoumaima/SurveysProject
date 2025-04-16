package horizon.surveyservice.service;

import horizon.surveyservice.dto.SurveyDto;

import java.util.List;

public interface SurveyService {
    SurveyDto createSurvey(SurveyDto surveyDto);
    SurveyDto getSurveyById(Long surveyId);
    List<SurveyDto> getAllSurveys();
    SurveyDto updateSurvey(Long surveyId, SurveyDto surveyDto);
    void deleteSurvey(Long surveyId);
//    SurveyDto patchSurveyLocked(Long id, boolean locked);
}
