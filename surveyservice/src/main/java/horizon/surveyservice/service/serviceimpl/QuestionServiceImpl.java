package horizon.surveyservice.service.serviceimpl;

import horizon.surveyservice.DTO.QuestionDto;
import horizon.surveyservice.entity.Question;
import horizon.surveyservice.exeptions.ResourceNotFoundException;
import horizon.surveyservice.mapper.QuestionMapper;
import horizon.surveyservice.repository.QuestionRepository;
import horizon.surveyservice.service.QuestionService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    @Override
    public List<QuestionDto> getAllQuestions() {
        return List.of();
    }

    @Override
    public QuestionDto getQuestionById(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found with id:"+id));
        return QuestionMapper.toDTO(question);

    }

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        Question question = QuestionMapper.toEntity(questionDto);
        Question saved = questionRepository.save(question);
        return QuestionMapper.toDTO(saved);
    }

    @Override
    public QuestionDto updateQuestion(QuestionDto questionDto) {
        return null;
    }

    @Override
    public void deleteQuestion(Long id) {

    }
}
