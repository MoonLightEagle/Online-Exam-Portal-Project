package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.entity.Exam;
import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.service.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }
    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id){
        return examService.getExamById(id);
    }
    @GetMapping("/{id}/students")
    public List<Student> getStudentsByExamId(@PathVariable Long id){
        return examService.getStudentsByExamId(id);
    }

    @PostMapping()
    public Exam postExam(@RequestBody Exam exam){
        return examService.postExam(exam);
    }

    @PutMapping("/{id}")
    public Exam putExamById(@PathVariable Long id, @RequestBody Exam exam){
        return examService.putExamById(id, exam);
    }
    @DeleteMapping("/{id}")
    public Exam deleteExamById(@PathVariable Long id){
        return examService.deleteExamById(id);
    }

}
