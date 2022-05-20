package com.example.codingbatstructure.service;

import com.example.codingbatstructure.entity.Answer;
import com.example.codingbatstructure.entity.Task;
import com.example.codingbatstructure.entity.User;
import com.example.codingbatstructure.payload.AnswerDto;
import com.example.codingbatstructure.payload.ApiResponse;
import com.example.codingbatstructure.repository.AnswerRepo;
import com.example.codingbatstructure.repository.TaskRepo;
import com.example.codingbatstructure.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    AnswerRepo answerRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    TaskRepo taskRepo;

    public List<Answer> getAnswers(){
        return answerRepo.findAll();
    }

    public Answer getAnswerById(Integer id){
        Optional<Answer> optionalAnswer = answerRepo.findById(id);
        return  optionalAnswer.orElse(null);
    }

    public ApiResponse addAnswer(AnswerDto answerDto){
        Optional<Task> optionalTask = taskRepo.findById(answerDto.getTaskId());
        if(!optionalTask.isPresent()){
            return new ApiResponse("Bunday idlik task mavjud emas!",false);
        }

        Optional<User> optionalUser = userRepo.findById(answerDto.getUserId());
        if(!optionalUser.isPresent()){
            return new ApiResponse("Bunday idlik user mavjud emas!",false);
        }
        Answer answer = new Answer();
        answer.setText(answerDto.getText());
        answer.set_correct(answerDto.is_correct());
        answer.setTask(optionalTask.get());
        answer.setUser(optionalUser.get());
        answerRepo.save(answer);
        return  new ApiResponse("Answer qo'shildi", true);
    }
    public ApiResponse editAnswer(AnswerDto answerDto,Integer id){
        Optional<Answer> optionalAnswer = answerRepo.findById(id);
        if(!optionalAnswer.isPresent()){
            return new ApiResponse("Bunday idlik answer mavjud emas!",false);
        }
        Optional<Task> optionalTask = taskRepo.findById(answerDto.getTaskId());
        if(!optionalTask.isPresent()){
            return new ApiResponse("Bunday idlik task mavjud emas!",false);
        }

        Optional<User> optionalUser = userRepo.findById(answerDto.getUserId());
        if(!optionalUser.isPresent()){
            return new ApiResponse("Bunday idlik user mavjud emas!",false);
        }
        Answer answer = optionalAnswer.get();
        answer.setText(answerDto.getText());
        answer.set_correct(answerDto.is_correct());
        answer.setTask(optionalTask.get());
        answer.setUser(optionalUser.get());
        answerRepo.save(answer);
        return new ApiResponse("Answer tahrirlandi",true);
    }

    public ApiResponse deleteAnswer(Integer id){
        Optional<Answer> optionalAnswer = answerRepo.findById(id);
        if(!optionalAnswer.isPresent()){
            return new ApiResponse("Bunday idlik answer mavjud emas!",false);
        }
        Answer answer = optionalAnswer.get();
        answerRepo.delete(answer);
        return new ApiResponse("Answer o'chirildi !", true);
    }
}
