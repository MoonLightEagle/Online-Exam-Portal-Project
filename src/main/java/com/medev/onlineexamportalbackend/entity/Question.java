package com.medev.onlineexamportalbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionBody;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private byte answerId;
}
