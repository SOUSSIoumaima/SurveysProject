package horizon.surveyservice.service;

import horizon.surveyservice.dto.SurveyDto;

import java.util.List;

public interface SurveyService {
    SurveyDto createSurvey(SurveyDto surveyDto);

    SurveyDto getSurveyById(String surveyId);

    List<SurveyDto> getAllSurveys();

    SurveyDto updateSurvey(String surveyId, SurveyDto surveyDto);

    void deleteSurvey(String surveyId);

    SurveyDto patchSurvey(Long id, boolean locked);
}
