package com.medev.onlineexamportalbackend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private Long teacherId;

    @Setter
    @Getter
    private String name;

    @OneToMany(targetEntity = Question.class,
            cascade = CascadeType.ALL)
    @JoinTable(name = "questions_exam",
        joinColumns = {@JoinColumn(name = "id")},
        inverseJoinColumns = {@JoinColumn(name="question_id")})
    @Setter
    @Getter
    private List<Question> questions = new ArrayList<Question>();

    @ManyToMany(fetch= FetchType.EAGER,
    cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "student_exams",
        joinColumns={@JoinColumn(name="id")},
        inverseJoinColumns = {@JoinColumn(name = "student_id")})
    @Setter
    @Getter
    private List<Student> students = new ArrayList<Student>();

    @Setter
    @Getter
    private Long gradeId;

}
