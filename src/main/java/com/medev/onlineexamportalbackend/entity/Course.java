package com.medev.onlineexamportalbackend.entity;

import jakarta.persistence.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToMany(fetch= FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "student_courses",
            joinColumns={@JoinColumn(name="id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})

    private List<Student> students = new ArrayList<Student>();

    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers = new ArrayList<Teacher>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
