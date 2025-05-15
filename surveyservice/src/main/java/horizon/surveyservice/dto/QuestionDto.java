package horizon.surveyservice.DTO;

import horizon.surveyservice.entity.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionDto {
    private Long questionId;
    private String subject;
    private String questionText;
    private QuestionType questionType;
    private boolean locked;
    private List<OptionDto> options;
}
