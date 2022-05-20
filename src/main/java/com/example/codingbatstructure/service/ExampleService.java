package com.example.codingbatstructure.service;

import com.example.codingbatstructure.entity.Example;
import com.example.codingbatstructure.entity.Task;
import com.example.codingbatstructure.payload.ApiResponse;
import com.example.codingbatstructure.payload.ExampleDto;
import com.example.codingbatstructure.repository.ExampleRepo;
import com.example.codingbatstructure.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExampleService {
    @Autowired
    ExampleRepo exampleRepo;

    @Autowired
    TaskRepo taskRepo;

    public List<Example> getExamples(){
        return exampleRepo.findAll();
    }

    public Example getExampleById(Integer id){
        Optional<Example> optionalExample = exampleRepo.findById(id);
        return  optionalExample.orElse(null);
    }

    public ApiResponse addExample(ExampleDto exampleDto){
        Optional<Task> optionalTask = taskRepo.findById(exampleDto.getTaskId());
        if(!optionalTask.isPresent()){
            return new ApiResponse("Bunday idlik task mavjud emas!",false);
        }
        Example example = new Example();
        example.setText(exampleDto.getText());
        example.setTask(optionalTask.get());
        exampleRepo.save(example);
        return  new ApiResponse("Example qo'shildi", true);
    }
    public ApiResponse editExample(ExampleDto exampleDto,Integer id){
        Optional<Example> optionalExample = exampleRepo.findById(id);
        if(!optionalExample.isPresent()){
            return new ApiResponse("Bunday idlik example mavjud emas!",false);
        }
        Optional<Task> optionalTask = taskRepo.findById(exampleDto.getTaskId());
        if(!optionalTask.isPresent()){
            return new ApiResponse("Bunday idlik task mavjud emas!",false);
        }
        Example example = optionalExample.get();
        example.setText(exampleDto.getText());
        example.setTask(optionalTask.get());
        exampleRepo.save(example);
        return new ApiResponse("Example tahrirlandi",true);
    }

    public ApiResponse deleteExample(Integer id){
        Optional<Example> optionalExample = exampleRepo.findById(id);
        if(!optionalExample.isPresent()){
            return new ApiResponse("Bunday idlik example mavjud emas!",false);
        }
        Example example = optionalExample.get();
        exampleRepo.delete(example);
        return new ApiResponse("Example o'chirildi !", true);
    }
}
