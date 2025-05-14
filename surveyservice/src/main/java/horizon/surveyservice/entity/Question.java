package horizon.surveyservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String questionText;
    @Column(nullable = false)
    private QuestionType questionType;
    @Column(nullable = false)
    @JsonBackReference
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Option> options;
    @Column(nullable = false)
    private boolean locked;







}
