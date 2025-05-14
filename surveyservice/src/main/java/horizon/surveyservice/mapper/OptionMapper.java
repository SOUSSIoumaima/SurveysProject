package horizon.surveyservice.mapper;

import horizon.surveyservice.DTO.OptionDto;
import horizon.surveyservice.entity.Option;
import horizon.surveyservice.entity.Question;

public class OptionMapper {

    public static OptionDto toDto(Option option) {
        OptionDto dto = new OptionDto();
        dto.setOptionId(option.getOptionId());
        dto.setQuestionId(option.getQuestion() != null ? option.getQuestion().getQuestionId() : null);
        dto.setOptionText(option.getOptionText());
        dto.setOptionText(option.getOptionText());
        dto.setCorrect(option.isCorrect());
        dto.setOptionScore(option.getOptionScore());
        dto.setLocked(option.isLocked());
        return dto;

    }
    public static Option toEntity(OptionDto dto, Question question) {
        Option option = new Option();
        option.setOptionId(dto.getOptionId());
        option.setQuestion(question);
        option.setOptionText(dto.getOptionText());
        option.setCorrect(dto.isCorrect());
        option.setOptionScore(dto.getOptionScore());
        option.setLocked(dto.isLocked());
        return option;

    }
}
