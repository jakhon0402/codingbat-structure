package com.example.codingbatstructure.controller;

import com.example.codingbatstructure.entity.Example;
import com.example.codingbatstructure.payload.ApiResponse;
import com.example.codingbatstructure.payload.ExampleDto;
import com.example.codingbatstructure.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/example")
public class ExampleController {
    @Autowired
    ExampleService exampleService;

    @GetMapping
    public List<Example> getExamples(){
        return exampleService.getExamplees();
    }

    @GetMapping("/{id}")
    public Example getExample(@PathVariable Integer id){
        return exampleService.getExampleById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addExample(@Valid @RequestBody ExampleDto exampleDto){
        ApiResponse apiResponse = exampleService.addExample(exampleDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editExample(@Valid @RequestBody ExampleDto exampleDto,
                                                   @PathVariable Integer id){
        ApiResponse apiResponse = exampleService.editExample(exampleDto, id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteExample(@PathVariable Integer id){
        ApiResponse apiResponse = exampleService.deleteExample(id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }
}
