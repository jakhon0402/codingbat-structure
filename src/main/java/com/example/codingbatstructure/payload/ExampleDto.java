package com.example.codingbatstructure.payload;

import com.example.codingbatstructure.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExampleDto {

    @NotNull(message = "text bo'sh bo'lmasligi kerak !")
    private String text;

    @NotNull(message = "taskId bo'sh bo'lmasligi kerak !")
    private Integer taskId;
}
