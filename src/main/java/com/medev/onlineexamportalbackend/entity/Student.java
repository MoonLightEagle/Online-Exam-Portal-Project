package com.medev.onlineexamportalbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Long grade;

    private String email;

    private String contactPhone;

    @ManyToMany(mappedBy = "students")
    private List<Exam> exams = new ArrayList<Exam>();

    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<Course>();


}
