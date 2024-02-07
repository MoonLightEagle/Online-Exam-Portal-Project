package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.dto.CreateStudentRequest;
import com.medev.onlineexamportalbackend.dto.UpdateStudentRequest;
import com.medev.onlineexamportalbackend.entity.Student;

import com.medev.onlineexamportalbackend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student createStudent(@RequestBody CreateStudentRequest createStudentRequest){
        return studentService.createStudent(createStudentRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable Long id, @RequestBody UpdateStudentRequest updateStudentRequest){
        return studentService.updateStudentById(id,updateStudentRequest);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }

}
