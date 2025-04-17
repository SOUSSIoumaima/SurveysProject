package horizon.surveyservice.dto;

import java.time.LocalDateTime;

public class ResponseDto {
    private Long responseId;
    private Long questionId;
    private Long surveyId;
    private Long respondentId;
    private String Text;
    private boolean isCorrect;
    private Integer score;
    private LocalDateTime submittedAt;
}
