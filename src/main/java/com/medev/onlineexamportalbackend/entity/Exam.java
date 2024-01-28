package com.medev.onlineexamportalbackend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long teacherId;
    private String name;

    @OneToMany(targetEntity = Question.class,
            cascade = CascadeType.ALL)
    @JoinTable(name = "questions_exam",
        joinColumns = {@JoinColumn(name = "id")},
        inverseJoinColumns = {@JoinColumn(name="question_id")})
    private List<Question> questions = new ArrayList<Question>();

    @ManyToMany(fetch= FetchType.LAZY,
    cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "student_exams",
        joinColumns={@JoinColumn(name="id")},
        inverseJoinColumns = {@JoinColumn(name = "student_id")})

    private List<Student> students = new ArrayList<Student>();
    private Long gradeId;



}
