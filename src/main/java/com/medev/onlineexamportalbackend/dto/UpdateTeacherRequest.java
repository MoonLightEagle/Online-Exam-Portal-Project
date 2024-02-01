package com.medev.onlineexamportalbackend.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UpdateTeacherRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String contactPhone;
}
