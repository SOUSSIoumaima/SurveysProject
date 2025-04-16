package horizon.surveyservice.mapper;

import horizon.surveyservice.dto.SurveyDto;
import horizon.surveyservice.entity.Survey;
import horizon.surveyservice.entity.SurveyStatus;
import horizon.surveyservice.entity.SurveyType;

public class SurveyMapper {
    public static SurveyDto toSurveyDto(Survey survey) {
        return new SurveyDto(
                survey.getSurveyId(),
                survey.getType().name(),
                survey.getTitle(),
                survey.getDescription(),
                survey.getStatus().name(),
                survey.getCreatedAt(),
                survey.getUpdatedAt(),
                survey.getDeadline(),
                survey.isLocked(),
                survey.getTotalScore(),
                null
        );
    }
    public static Survey toSurvey(SurveyDto surveyDto){
        Survey survey = new Survey();
        survey.setSurveyId(surveyDto.getSurveyId());
        survey.setType(SurveyType.valueOf(surveyDto.getType()));
        survey.setTitle(surveyDto.getTitle());
        survey.setDescription(surveyDto.getDescription());
        survey.setStatus(SurveyStatus.valueOf(surveyDto.getStatus()));
        survey.setCreatedAt(surveyDto.getCreatedAt());
        survey.setUpdatedAt(surveyDto.getUpdatedAt());
        survey.setDeadline(surveyDto.getDeadline());
        survey.setLocked(surveyDto.isLocked());
        survey.setTotalScore(surveyDto.getTotalScore());
        // Pas encore les questions
        return survey;
    }
}
