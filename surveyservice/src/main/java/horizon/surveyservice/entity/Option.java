package horizon.surveyservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "option")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;

    @ManyToOne
    @JoinColumn(name= "questionId",referencedColumnName = "questionId")
    private Question question;
    @Column(nullable = false)
    private String optionText;
    @Column(nullable = false)
    private boolean isCorrect;
    @Column(nullable = false)
    private Long optionScore;
    @Column(nullable = false)
    private boolean isLocked;



}
