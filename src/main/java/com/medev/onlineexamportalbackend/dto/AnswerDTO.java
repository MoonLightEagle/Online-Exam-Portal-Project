package com.medev.onlineexamportalbackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Builder
@Getter
@Setter
public class AnswerDTO {
    private List<Long> answersIds;
}
