package com.example.codingbatstructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String solution;

    @Column(nullable = false)
    private String hint;

    @Column(nullable = false)
    private String method;

    @Column(nullable = false)
    private String has_star;

    @ManyToOne
    private Language language;
}
