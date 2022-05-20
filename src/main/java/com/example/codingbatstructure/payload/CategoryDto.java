package com.example.codingbatstructure.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotNull(message = "name bo'sh bo'lmasligi kerak !")
    private String name;

    @NotNull(message = "description bo'sh bo'lmasligi kerak !")
    private String description;
}
