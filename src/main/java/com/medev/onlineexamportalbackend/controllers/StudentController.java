package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.entity.Student;

import com.medev.onlineexamportalbackend.service.StudentService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getAllStudents(){

        return studentService.getAllStudents();
    }


    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){

        Student student = studentService.getStudentById(id);
        return student;

    }

    @PostMapping
    public Student postStudent(@RequestBody Student student){
        return studentService.postStudent(student);
    }

    @PutMapping("/{id}")
    public Student putStudentById(@PathVariable Long id, @RequestBody Student student){

        return studentService.putStudentById(id,student);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }

}
