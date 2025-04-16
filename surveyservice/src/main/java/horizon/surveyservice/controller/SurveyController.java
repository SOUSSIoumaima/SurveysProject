package horizon.surveyservice.controller;

import horizon.surveyservice.dto.SurveyDto;
import horizon.surveyservice.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/surveys")
@RequiredArgsConstructor
public class SurveyController {
    private SurveyService surveyService;

    @PostMapping
    public ResponseEntity<SurveyDto> createSurvey(@RequestBody SurveyDto surveyDto){
        SurveyDto createdSurvey = surveyService.createSurvey(surveyDto);
        return new ResponseEntity<>(createdSurvey, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SurveyDto>> getAllSurveys(){
        return ResponseEntity.ok(surveyService.getAllSurveys());
    }

    @GetMapping("/{surveyId}")
    public ResponseEntity<SurveyDto> getSurveyById(@PathVariable Long surveyId){
        return ResponseEntity.ok(surveyService.getSurveyById(surveyId));
    }

    @PutMapping("/{surveyId}")
    public ResponseEntity<SurveyDto> updateSurvey(@PathVariable Long surveyId, @RequestBody SurveyDto surveyDto){
        SurveyDto updatedSurvey = surveyService.updateSurvey(surveyId, surveyDto);
        return ResponseEntity.ok(updatedSurvey);
    }

    @DeleteMapping("/{surveyId}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long surveyId){
        surveyService.deleteSurvey(surveyId);
        return ResponseEntity.ok().build();
    }

//    @PatchMapping("/{surveyId}")
//    public ResponseEntity<SurveyDto> patchSurvey(@PathVariable Long surveyId, @RequestBody SurveyDto surveyDto){
//        SurveyDto patchedSurvey = surveyService.patchSurveyLocked(surveyId, patchData.isLocked());
//        return ResponseEntity.ok(patchedSurvey);
//    }

}
