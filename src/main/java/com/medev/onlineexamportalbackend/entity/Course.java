package com.medev.onlineexamportalbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private Grade grade;

    @ManyToMany(fetch= FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "student_courses",
            joinColumns={@JoinColumn(name="id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<Student> students = new ArrayList<Student>();

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "courses")
    private List<Exam> exams = new ArrayList<Exam>();

}
