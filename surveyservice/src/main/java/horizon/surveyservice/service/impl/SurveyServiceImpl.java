package horizon.surveyservice.service.impl;

import horizon.surveyservice.dto.SurveyDto;
import horizon.surveyservice.entity.Survey;
import horizon.surveyservice.entity.SurveyStatus;
import horizon.surveyservice.entity.SurveyType;
import horizon.surveyservice.mapper.SurveyMapper;
import horizon.surveyservice.repository.SurveyRepository;
import horizon.surveyservice.service.SurveyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepository surveyRepository;
    @Override
    public SurveyDto createSurvey(SurveyDto surveyDto) {
        Survey survey = SurveyMapper.toSurvey(surveyDto);
        survey.setCreatedAt(LocalDateTime.now());
        survey.setUpdatedAt(LocalDateTime.now());
        return SurveyMapper.toSurveyDto(surveyRepository.save(survey));
    }

    @Override
    public SurveyDto getSurveyById(Long surveyId) {
        Survey survey = surveyRepository.findById(surveyId).orElseThrow(()-> new EntityNotFoundException("Survey not found"));
        return SurveyMapper.toSurveyDto(survey);
    }

    @Override
    public List<SurveyDto> getAllSurveys() {
        return surveyRepository.findAll().stream().map(SurveyMapper::toSurveyDto).collect(Collectors.toList());
    }

    @Override
    public SurveyDto updateSurvey(Long surveyId, SurveyDto surveyDto) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new EntityNotFoundException("Survey not found"));
        survey.setTitle(surveyDto.getTitle());
        survey.setDescription(surveyDto.getDescription());
        survey.setStatus(SurveyStatus.valueOf(surveyDto.getStatus()));
        survey.setType(SurveyType.valueOf(surveyDto.getType()));
        survey.setDeadline(surveyDto.getDeadline());
        survey.setLocked(surveyDto.isLocked());
        survey.setUpdatedAt(LocalDateTime.now());
        survey.setTotalScore(surveyDto.getTotalScore());
        return SurveyMapper.toSurveyDto(surveyRepository.save(survey));
    }

    @Override
    public void deleteSurvey(Long surveyId) {
        surveyRepository.deleteById(surveyId);
    }

//    @Override
//    public SurveyDto patchSurveyLocked(Long id, boolean locked) {
//        Survey survey = surveyRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Survey not found"));
//        survey.setLocked(locked);
//        return SurveyMapper.toSurveyDto(surveyRepository.save(survey));
//    }
}
