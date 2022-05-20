package com.example.codingbatstructure.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    @NotNull(message = "text bo'sh bo'lmasligi kerak !")
    private String text;

    @NotNull(message = "taskId bo'sh bo'lmasligi kerak !")
    private Integer taskId;

    @NotNull(message = "userId bo'sh bo'lmasligi kerak !")
    private Integer userId;

    @NotNull(message = "name bo'sh bo'lmasligi kerak !")
    private boolean is_correct;
}
