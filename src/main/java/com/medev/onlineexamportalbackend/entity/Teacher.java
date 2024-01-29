package com.medev.onlineexamportalbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String grade;

    private String email;

    private String contactPhone;

    @ManyToMany(fetch= FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "course_teachers",
            joinColumns={@JoinColumn(name="id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> courses = new ArrayList<Course>();

    @ManyToMany(fetch= FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "grade_teachers",
            joinColumns={@JoinColumn(name="id")},
            inverseJoinColumns = {@JoinColumn(name = "grade_id")})
    private List<Grade> grades = new ArrayList<Grade>();


}
