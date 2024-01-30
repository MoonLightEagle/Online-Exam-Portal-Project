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
    @Column(nullable = false,length = 45)
    private String firstName;
    @Column(nullable = false,length = 45)
    private String lastName;

    private String grade;
    @Column(nullable = false, unique = true, length = 20)
    private String email;
    @Column(length = 12)
    private String contactPhone;
    @Column(nullable = false,length = 64)
    private String password;

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
