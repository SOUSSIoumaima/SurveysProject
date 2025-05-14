package horizon.surveyservice.DTO;

import horizon.surveyservice.entity.QuestionType;

import java.util.List;

public class QuestionDto {
    private Long questionId;
    private String subject;
    private String questionText;
    private QuestionType questionType;
    private boolean locked;
    private List<OptionDto> options;
}
