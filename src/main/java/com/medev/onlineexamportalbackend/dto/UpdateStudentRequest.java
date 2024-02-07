package com.medev.onlineexamportalbackend.dto;

import com.medev.onlineexamportalbackend.entity.Course;
import com.medev.onlineexamportalbackend.entity.Exam;
import com.medev.onlineexamportalbackend.entity.Grade;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class UpdateStudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String contactPhone;
    private Grade grade;
}
