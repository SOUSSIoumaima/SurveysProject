package horizon.surveyservice.controller;

import horizon.surveyservice.DTO.OptionDto;
import horizon.surveyservice.service.OptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/options")

public class OptionController {
    @Autowired
    private final OptionService optionService;
    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }
    @PostMapping
    public ResponseEntity<OptionDto> createOption(@RequestBody OptionDto optionDto) {
        return ResponseEntity.ok(optionService.createOption(optionDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<OptionDto> updateOption(@PathVariable Long id, @RequestBody OptionDto optionDto) {
        return ResponseEntity.ok(optionService.updateOption(id, optionDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<OptionDto> getOptionById(@PathVariable Long id) {
        return ResponseEntity.ok(optionService.getOptionById(id));
    }
    @GetMapping
    public ResponseEntity<List<OptionDto>> getAllOptions() {
        return ResponseEntity.ok(optionService.getAllOptions());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOption(@PathVariable Long id) {
        optionService.deleteOption(id);
        return ResponseEntity.noContent().build();
    }

}
