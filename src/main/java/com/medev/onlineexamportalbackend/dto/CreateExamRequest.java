package com.medev.onlineexamportalbackend.dto;

import lombok.Builder;
import lombok.Getter;
@Builder
@Getter
public class CreateExamRequest {
    private String name;
}
