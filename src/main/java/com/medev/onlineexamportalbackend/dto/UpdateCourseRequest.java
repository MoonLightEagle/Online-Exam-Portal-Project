package com.medev.onlineexamportalbackend.dto;

import com.medev.onlineexamportalbackend.entity.Exam;
import com.medev.onlineexamportalbackend.entity.Grade;
import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.entity.Teacher;
import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;


@Getter
public class UpdateCourseRequest {
    private String name;
    private String description;
    private List<Student> studentList;
    private List<Exam> examList;
    private Grade grade;
    private Teacher teacher;
}
