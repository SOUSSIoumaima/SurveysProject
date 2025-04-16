package horizon.surveyservice.service.impl;

import horizon.surveyservice.dto.SurveyDto;
import horizon.surveyservice.service.SurveyService;

import java.util.List;

public class SurveyServiceImpl implements SurveyService {
    @Override
    public SurveyDto createSurvey(SurveyDto surveyDto) {
        return null;
    }

    @Override
    public SurveyDto getSurveyById(String surveyId) {
        return null;
    }

    @Override
    public List<SurveyDto> getAllSurveys() {
        return List.of();
    }

    @Override
    public SurveyDto updateSurvey(String surveyId, SurveyDto surveyDto) {
        return null;
    }

    @Override
    public void deleteSurvey(String surveyId) {

    }

    @Override
    public SurveyDto patchSurvey(Long id, boolean locked) {
        return null;
    }
}
