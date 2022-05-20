package com.example.codingbatstructure.controller;

import com.example.codingbatstructure.entity.Category;
import com.example.codingbatstructure.payload.ApiResponse;
import com.example.codingbatstructure.payload.CategoryDto;
import com.example.codingbatstructure.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCompanies();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Integer id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addCategory(@Valid @RequestBody CategoryDto companyDto){
        ApiResponse apiResponse = categoryService.addCategory(companyDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editCategory(@Valid @RequestBody CategoryDto companyDto,
                                                   @PathVariable Integer id){
        ApiResponse apiResponse = categoryService.editCategory(companyDto, id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer id){
        ApiResponse apiResponse = categoryService.deleteCategory(id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }

}
