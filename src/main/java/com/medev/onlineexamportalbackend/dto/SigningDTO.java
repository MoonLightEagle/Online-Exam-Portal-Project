package com.medev.onlineexamportalbackend.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SigningDTO {
    private String email;
    private String password;
    private String role;
}
