package horizon.surveyservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;
    @Column(nullable = false)
    private String questionText;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionType questionType;

    @ElementCollection
    @CollectionTable(name = "question_responses", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "response_text")
    private List<Response> responses;
    private Integer score;
    private boolean locked;
}
