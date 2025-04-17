package horizon.surveyservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "response")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responseId;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;
    @Column(nullable = false)
    private Long respondentId;
    @Column(nullable = false)
    private String text;
    private boolean isCorrect;
    private Integer score;
    private LocalDateTime submittedAt;



}
