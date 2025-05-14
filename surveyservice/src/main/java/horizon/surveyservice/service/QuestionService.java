package horizon.surveyservice.service;

import horizon.surveyservice.DTO.QuestionDto;

import java.util.List;

public interface QuestionService {
    List<QuestionDto> getAllQuestions();
    QuestionDto getQuestionById(Long id);
    QuestionDto createQuestion(QuestionDto questionDto);
    QuestionDto updateQuestion(QuestionDto questionDto);
    void deleteQuestion(Long id);
}
