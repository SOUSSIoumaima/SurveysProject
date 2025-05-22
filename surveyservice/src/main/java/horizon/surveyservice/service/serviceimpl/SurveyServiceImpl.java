package horizon.surveyservice.service.serviceimpl;

import horizon.surveyservice.DTO.SurveyDto;
import horizon.surveyservice.entity.Survey;
import horizon.surveyservice.exeptions.ResourceNotFoundException;
import horizon.surveyservice.mapper.SurveyMapper;
import horizon.surveyservice.repository.QuestionRepository;
import horizon.surveyservice.repository.SurveyRepository;
import horizon.surveyservice.service.SurveyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;
//    private final QuestionRepository questionRepository;

    public SurveyServiceImpl(SurveyRepository surveyRepository, QuestionRepository questionRepository) {
        this.surveyRepository = surveyRepository;
//        this.questionRepository = questionRepository;
    }
    @Override
    public SurveyDto createSurvey(SurveyDto surveyDto) {
        Survey survey = SurveyMapper.toSurveyEntity(surveyDto);
        Survey saved=surveyRepository.save(survey);
        return SurveyMapper.toSurveyDto(saved);
    }

    @Override
    public List<SurveyDto> getAllSurveys() {
        List<Survey> surveys = surveyRepository.findAll();
        return surveys.stream()
                .map(SurveyMapper::toSurveyDto)
                .collect(Collectors.toList());

    }

    @Override
    public SurveyDto getSurveyById(Long surveyId) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(()-> new ResourceNotFoundException("Survey not found with id " + surveyId));
        return SurveyMapper.toSurveyDto(survey);
    }

    @Override
    public SurveyDto updateSurvey(Long surveyId, SurveyDto surveyDto) {
        Survey existing = surveyRepository.findById(surveyId)
                .orElseThrow(()-> new ResourceNotFoundException("Survey not found with id " + surveyId));
        existing.setTitle(surveyDto.getTitle());
        existing.setDescription(surveyDto.getDescription());
        existing.setStatus(surveyDto.getStatus());
        existing.setDeadline(surveyDto.getDeadline());
        existing.setLocked(surveyDto.isLocked());
        existing.setType(surveyDto.getType());
        Survey updated=surveyRepository.save(existing);
        return SurveyMapper.toSurveyDto(updated);
    }

    @Override
    public void deleteSurvey(Long surveyId) {
        Survey existing = surveyRepository.findById(surveyId)
                .orElseThrow(()-> new ResourceNotFoundException("Survey not found with id " + surveyId));
        surveyRepository.delete(existing);

    }
}
