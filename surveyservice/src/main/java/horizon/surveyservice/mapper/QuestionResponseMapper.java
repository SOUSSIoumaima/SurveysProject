package horizon.surveyservice.mapper;

import horizon.surveyservice.DTO.QuestionResponseDto;
import horizon.surveyservice.entity.OptionResponse;
import horizon.surveyservice.entity.QuestionResponse;
import horizon.surveyservice.entity.SurveyResponse;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionResponseMapper {
    public static QuestionResponseDto toDto(QuestionResponse entity) {
        if (entity == null) return null;
        QuestionResponseDto dto = new QuestionResponseDto();
        dto.setQuestionResponseId(entity.getQuestionResponseId());
        dto.setQuestionId(entity.getQuestionId());
        dto.setQuestionText(entity.getQuestionText());
        dto.setQuestionScore(entity.getQuestionScore());
        dto.setSubmittedAt(entity.getSubmittedAt());
        if (entity.getOptionResponses() != null) {
            dto.setSurveyResponseId(entity.getSurveyResponse().getSurveyResponseId());
        }
        return dto;
    }
    public static QuestionResponse toEntity(QuestionResponseDto dto, SurveyResponse surveyResponse) {
        if (dto == null) return null;
        QuestionResponse entity = new QuestionResponse();
        entity.setQuestionResponseId(dto.getQuestionResponseId());
        entity.setQuestionId(dto.getQuestionId());
        entity.setQuestionText(dto.getQuestionText());
        entity.setQuestionScore(dto.getQuestionScore());
        entity.setSubmittedAt(dto.getSubmittedAt());
        entity.setSurveyResponse(surveyResponse);
        return entity;
    }

}
