package horizon.surveyservice.DTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OptionDto {
    private Long optionId;
    private Long questionId;
    private String optionText;
    private boolean isCorrect;
    private Long optionScore;
    private boolean isLocked;

}
