package horizon.surveyservice.controller;

import horizon.surveyservice.DTO.SurveyDto;

import horizon.surveyservice.exeptions.ResourceNotFoundException;
import horizon.surveyservice.service.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survey")
public class SurveyController {
    private final SurveyService surveyService;
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }
    @PostMapping
    public ResponseEntity<SurveyDto> createSurvey(@RequestBody SurveyDto surveyDto) {
        SurveyDto createdSurvey = surveyService.createSurvey(surveyDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSurvey);
    }

    @GetMapping
    public ResponseEntity<List<SurveyDto>> getAllSurveys(){
        List<SurveyDto> allSurveys = surveyService.getAllSurveys();
        return ResponseEntity.status(HttpStatus.OK).body(allSurveys);
    }

    @GetMapping("/{surveyId}")
    public ResponseEntity<SurveyDto> getSurveyById(@PathVariable Long surveyId){
        try {
            SurveyDto surveyDto = surveyService.getSurveyById(surveyId);
            return ResponseEntity.ok(surveyDto);
            } catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{surveyId}")
    public ResponseEntity<?> updateSurvey(@PathVariable Long surveyId, @RequestBody SurveyDto surveyDto) {
        try {
            SurveyDto updated = surveyService.updateSurvey(surveyId, surveyDto);
            return ResponseEntity.ok(updated);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{surveyId}")
    public ResponseEntity<?> deleteSurvey(@PathVariable Long surveyId) {
        try {
            surveyService.deleteSurvey(surveyId);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



}
