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
    @Column(nullable = false, length = 45)
    private String firstName;
    @Column(nullable = false, length = 45)
    private String lastName;

    private Long grade;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(length = 12)
    private String contactPhone;
    @Column(nullable = false, length = 64)
    private String password;

    @ManyToMany(mappedBy = "students")
    private List<Exam> exams = new ArrayList<Exam>();

    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<Course>();


}
