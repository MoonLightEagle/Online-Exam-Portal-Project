package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.dto.CreateExamRequest;
import com.medev.onlineexamportalbackend.dto.UpdateExamRequest;
import com.medev.onlineexamportalbackend.entity.Exam;
import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamController {
    private final ExamService examService;

    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id){
        return examService.getExamById(id);
    }

    @GetMapping("/{id}/students")
    public List<Student> getStudentsByExamId(@PathVariable Long id){
        return examService.getStudentsByExamId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Exam createExam(@RequestBody CreateExamRequest createExamRequest){
        return examService.createExam(createExamRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Exam updateExamById(@PathVariable Long id, @RequestBody UpdateExamRequest updateExamRequest){
        return examService.updateExamById(id, updateExamRequest);
    }

    @DeleteMapping("/{id}")
    public Exam deleteExamById(@PathVariable Long id){
        return examService.deleteExamById(id);
    }

}
