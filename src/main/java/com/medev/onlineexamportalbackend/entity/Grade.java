package com.medev.onlineexamportalbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "grades")
    private List<Course> courses = new ArrayList<Course>();

    @ManyToMany(mappedBy = "grades")
    private List<Teacher> teachers = new ArrayList<Teacher>();

    @OneToMany(mappedBy = "grades")
    private List<Student> students = new ArrayList<Student>();


}
