package com.example.codingbatstructure.service;

import com.example.codingbatstructure.entity.Category;
import com.example.codingbatstructure.payload.ApiResponse;
import com.example.codingbatstructure.payload.CategoryDto;
import com.example.codingbatstructure.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> getCategories(){
        return categoryRepo.findAll();
    }

    public Category getCategory(Integer id){
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        return optionalCategory.orElse(null);
    }

    public ApiResponse addCategory(CategoryDto categoryDto){

        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        categoryRepo.save(category);
        return new ApiResponse("Category qo'shildi !",true);
    }

    public ApiResponse editCategory(CategoryDto categoryDto,Integer id){
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(!optionalCategory.isPresent()){
            return new ApiResponse("Bunday idlik category mavjud emas !", false);
        }
        Category category = optionalCategory.get();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        categoryRepo.save(category);
        categoryRepo.save(category);
        return new ApiResponse("Category tahrirlandi !", true);
    }

    public ApiResponse deleteCategory(Integer id){
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(!optionalCategory.isPresent()){
            return new ApiResponse("Bunday idlik category mavjud emas !", false);
        }
        categoryRepo.delete(optionalCategory.get());
        return new ApiResponse("Category o'childi !", true);
    }
}
