package com.medev.onlineexamportalbackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class StudentCourseDTO {
    private Long courseId;
    private Long studentId;
}
