package com.example.codingbatstructure.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
    @NotNull(message = "username bo'sh bo'lmasligi kerak !")
    private String username;

    @NotNull(message = "password bo'sh bo'lmasligi kerak !")
    private String password;

    @NotNull(message = "email bo'sh bo'lmasligi kerak !")
    private String email;
}
