package com.medev.onlineexamportalbackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class CreateGradeRequest {
    private String name;
    private String description;
}
