package com.example.codingbatstructure.controller;

import com.example.codingbatstructure.entity.User;
import com.example.codingbatstructure.payload.ApiResponse;
import com.example.codingbatstructure.payload.LoginDto;
import com.example.codingbatstructure.payload.RegistrationDto;
import com.example.codingbatstructure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@Valid @RequestBody LoginDto loginDto){
        ApiResponse apiResponse = userService.loginUser(loginDto);
        return ResponseEntity.status(apiResponse.isStatus()?200:409).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addUser(@Valid @RequestBody RegistrationDto registrationDto){
        ApiResponse apiResponse = userService.addUser(registrationDto);
        return ResponseEntity.status(apiResponse.isStatus()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editUser(@Valid @RequestBody RegistrationDto registrationDto,
                                                @PathVariable Integer id){
        ApiResponse apiResponse = userService.editUser(id,registrationDto);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id){
        ApiResponse apiResponse = userService.deleteUser(id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }
}
