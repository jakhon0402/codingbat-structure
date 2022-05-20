package com.example.codingbatstructure.service;

import com.example.codingbatstructure.entity.Language;
import com.example.codingbatstructure.entity.Task;
import com.example.codingbatstructure.payload.ApiResponse;
import com.example.codingbatstructure.payload.TaskDto;
import com.example.codingbatstructure.repository.LanguageRepo;
import com.example.codingbatstructure.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepo taskRepo;

    @Autowired
    LanguageRepo languageRepo;

    public List<Task> getTasks(){
        return taskRepo.findAll();
    }

    public Task getTask(Integer id){
        Optional<Task> optionalTask = taskRepo.findById(id);
        return optionalTask.orElse(null);
    }

    public ApiResponse addTask(TaskDto taskDto){

        Language language = new Language();
        language.setName(taskDto.getLanguage_name());
        Language savedLanguage = languageRepo.save(language);

        Task task = new Task();
        task.setName(taskDto.getName());
        task.setText(taskDto.getText());
        task.setSolution(taskDto.getSolution());
        task.setHint(taskDto.getHint());
        task.setMethod(taskDto.getMethod());
        task.setHas_star(taskDto.getHas_star());
        task.setLanguage(savedLanguage);
        taskRepo.save(task);
        return new ApiResponse("Task qo'shildi !",true);
    }

    public ApiResponse editTask(TaskDto taskDto,Integer id){
        Optional<Task> optionalTask = taskRepo.findById(id);
        if(!optionalTask.isPresent()){
            return new ApiResponse("Bunday idlik task mavjud emas !", false);
        }
        Language language = optionalTask.get().getLanguage();
        language.setName(taskDto.getLanguage_name());
        Language savedLanguage = languageRepo.save(language);

        Task task = optionalTask.get();
        task.setName(taskDto.getName());
        task.setText(taskDto.getText());
        task.setSolution(taskDto.getSolution());
        task.setHint(taskDto.getHint());
        task.setMethod(taskDto.getMethod());
        task.setHas_star(taskDto.getHas_star());
        task.setLanguage(savedLanguage);
        taskRepo.save(task);
        return new ApiResponse("Task tahrirlandi !", true);
    }

    public ApiResponse deleteTask(Integer id){
        Optional<Task> optionalTask = taskRepo.findById(id);
        if(!optionalTask.isPresent()){
            return new ApiResponse("Bunday idlik task mavjud emas !", false);
        }
        taskRepo.delete(optionalTask.get());
        return new ApiResponse("Task o'childi !", true);
    }

}
