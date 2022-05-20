package com.example.codingbatstructure.payload;

import com.example.codingbatstructure.entity.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    @NotNull(message = "name bo'sh bo'lmasligi kerak !")
    private String name;

    @NotNull(message = "text bo'sh bo'lmasligi kerak !")
    private String text;

    @NotNull(message = "solution bo'sh bo'lmasligi kerak !")
    private String solution;

    @NotNull(message = "hint bo'sh bo'lmasligi kerak !")
    private String hint;

    @NotNull(message = "method bo'sh bo'lmasligi kerak !")
    private String method;

    @NotNull(message = "has_star bo'sh bo'lmasligi kerak !")
    private String has_star;

    @NotNull(message = "language_name bo'sh bo'lmasligi kerak !")
    private String language_name;
}
