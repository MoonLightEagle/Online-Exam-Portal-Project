package com.medev.onlineexamportalbackend.dto;

import com.medev.onlineexamportalbackend.entity.Course;
import com.medev.onlineexamportalbackend.entity.Teacher;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UpdateExamRequest {
    private String name;
    private Teacher teacher;
    private Course course;

}
