package com.example.codingbatstructure.controller;

import com.example.codingbatstructure.entity.Answer;
import com.example.codingbatstructure.payload.AnswerDto;
import com.example.codingbatstructure.payload.ApiResponse;
import com.example.codingbatstructure.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @GetMapping
    public List<Answer> getAnswers(){
        return answerService.getAnswers();
    }

    @GetMapping("/{id}")
    public Answer getAnswer(@PathVariable Integer id){
        return answerService.getAnswerById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addAnswer(@Valid @RequestBody AnswerDto answerDto){
        ApiResponse apiResponse = answerService.addAnswer(answerDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editAnswer(@Valid @RequestBody AnswerDto answerDto,
                                                   @PathVariable Integer id){
        ApiResponse apiResponse = answerService.editAnswer(answerDto, id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAnswer(@PathVariable Integer id){
        ApiResponse apiResponse = answerService.deleteAnswer(id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }
}
