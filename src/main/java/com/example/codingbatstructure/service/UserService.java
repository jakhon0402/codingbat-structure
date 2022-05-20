package com.example.codingbatstructure.service;

import com.example.codingbatstructure.entity.User;
import com.example.codingbatstructure.payload.ApiResponse;
import com.example.codingbatstructure.payload.LoginDto;
import com.example.codingbatstructure.payload.RegistrationDto;
import com.example.codingbatstructure.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User getUser(Integer id){
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.orElse(null);
    }

    public ApiResponse loginUser(LoginDto loginDto){
        if(!userRepo.existsByUsername(loginDto.getUsername())){
            return new ApiResponse("Ushbu username mavjud emas !", false);
        }
        User username = userRepo.findByUsername(loginDto.getUsername());
        if(!loginDto.getPassword().equals(username.getPassword())){
            return new ApiResponse("Parol xato kiritilgan !", false);
        }
        return new ApiResponse("Successfully logged in !",true);
    }

    public ApiResponse addUser(RegistrationDto registrationDto){
        if(userRepo.existsByUsername(registrationDto.getUsername())){
            return new ApiResponse("Ushbu username mavjud !", false);
        }
        User newUser = new User();
        newUser.setUsername(registrationDto.getUsername());
        newUser.setEmail(registrationDto.getEmail());
        newUser.setPassword(registrationDto.getPassword());
        userRepo.save(newUser);
        return new ApiResponse("User qo'shildi !", true);
    }

    public ApiResponse editUser(Integer id,RegistrationDto registrationDto){
        Optional<User> optionalUser = userRepo.findById(id);
        if(!optionalUser.isPresent()){
            return new ApiResponse("Ushbu idlik username mavjud emas!", false);
        }
        User newUser = optionalUser.get();
        if(userRepo.existsByUsernameAndIdIsNot(newUser.getUsername(),id)){
            return new ApiResponse("Ushbu usernamelik user tizimda mavjud !", false);
        }

        newUser.setUsername(registrationDto.getUsername());
        newUser.setEmail(registrationDto.getEmail());
        newUser.setPassword(registrationDto.getPassword());
        userRepo.save(newUser);
        return new ApiResponse("User tahrirlandi !", true);
    }

    public ApiResponse deleteUser(Integer id){
        Optional<User> optionalUser = userRepo.findById(id);
        if(!optionalUser.isPresent()){
            return new ApiResponse("Ushbu idlik username mavjud emas!", false);
        }
        userRepo.delete(optionalUser.get());
        return new ApiResponse("User o'chirildi !", true);
    }
}
