package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.service.ExamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/{id}/students")
    public List<Student> getStudentsByExamId(@PathVariable Long id){
        return examService.getStudentsByExamId(id);
    }


}
