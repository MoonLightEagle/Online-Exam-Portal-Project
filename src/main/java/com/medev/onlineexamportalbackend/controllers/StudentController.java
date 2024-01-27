package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.entity.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping
    public void getAllStudents(){
        // TODO endpoint to get list of all students
    }
    @GetMapping("/{id}")
    public void getStudentsByGradeId(@PathVariable Long id){
        // TODO endpoint to get list of students on gradeId
    }

    @GetMapping("/{id}")
    public void getStudentsByExamId(@PathVariable Long id){
        // TODO endpoint to get list of students on ExamId
    }

    @PostMapping
    public void postStudent(@RequestBody Student student){
        // TODO endpoint to register student
    }

    @PutMapping("/{id}")
    public void putStudentById(@PathVariable Long id, @RequestBody Student student){
        // TODO endpoint to put data by studentId
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        // TODO endpoint to delete student by studentId
    }

}
