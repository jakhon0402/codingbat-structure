package com.example.codingbatstructure.controller;

import com.example.codingbatstructure.entity.Language;
import com.example.codingbatstructure.payload.ApiResponse;
import com.example.codingbatstructure.payload.LanguageDto;
import com.example.codingbatstructure.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    LanguageService languageService;

    @GetMapping
    public List<Language> getCompanies(){
        return languageService.getLanguages();
    }

    @GetMapping("/{id}")
    public Language getLanguage(@PathVariable Integer id){
        return languageService.getLanguage(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addLanguage(@Valid @RequestBody LanguageDto companyDto){
        ApiResponse apiResponse = languageService.addLanguage(companyDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editLanguage(@Valid @RequestBody LanguageDto companyDto,
                                                   @PathVariable Integer id){
        ApiResponse apiResponse = languageService.editLanguage(companyDto, id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteLanguage(@PathVariable Integer id){
        ApiResponse apiResponse = languageService.deleteLanguage(id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }
}
