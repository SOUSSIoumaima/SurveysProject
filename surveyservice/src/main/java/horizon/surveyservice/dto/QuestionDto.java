package horizon.surveyservice.dto;

import horizon.surveyservice.entity.QuestionType;

import java.util.List;

public class QuestionDto {
    private Long questionId;
    private Long surveyId;
    private String questionText;
    private QuestionType questionType;
    private List<ResponseDto> responses;
    private Integer score;
    private boolean locked;
}
