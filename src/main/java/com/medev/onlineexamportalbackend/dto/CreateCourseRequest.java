package com.medev.onlineexamportalbackend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateCourseRequest {
    private String name;
    private String description;

}
