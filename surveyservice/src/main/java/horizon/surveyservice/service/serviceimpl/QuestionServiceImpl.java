package horizon.surveyservice.service.serviceimpl;

import horizon.surveyservice.DTO.QuestionDto;
import horizon.surveyservice.repository.QuestionRepository;
import horizon.surveyservice.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    @Override
    public List<QuestionDto> getAllQuestions() {
        return List.of();
    }

    @Override
    public QuestionDto getQuestionById(Long id) {
        return null;
    }

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        return null;
    }

    @Override
    public QuestionDto updateQuestion(QuestionDto questionDto) {
        return null;
    }

    @Override
    public void deleteQuestion(Long id) {

    }
}
