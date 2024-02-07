package com.medev.onlineexamportalbackend.mapper;

import com.medev.onlineexamportalbackend.dto.CreateExamRequest;
import com.medev.onlineexamportalbackend.dto.UpdateExamRequest;
import com.medev.onlineexamportalbackend.entity.Exam;
import org.springframework.stereotype.Component;

@Component
public class ExamMapper {
    public Exam mapToExam(CreateExamRequest createExamRequest) {
        Exam exam = new Exam();
        exam.setName(createExamRequest.getName());
        return exam;
    }

    public void mapToExam(UpdateExamRequest updateExamRequest, Exam exam) {
        exam.setName(updateExamRequest.getName());
        exam.setTeacher(updateExamRequest.getTeacher());
        exam.setCourse(updateExamRequest.getCourse());
    }
}
