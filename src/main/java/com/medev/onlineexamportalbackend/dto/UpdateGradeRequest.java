package com.medev.onlineexamportalbackend.dto;

import com.medev.onlineexamportalbackend.entity.Course;
import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.entity.Teacher;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class UpdateGradeRequest {
    private String name;
    private String description;
    private List<Course> courses;
    private List<Teacher> teachers;
    private List<Student> students;
}
