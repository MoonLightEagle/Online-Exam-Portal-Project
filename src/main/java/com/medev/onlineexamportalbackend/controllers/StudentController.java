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
    private  final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(@RequestParam(name="grade", required = false) Long grade){

        return studentService.getAllStudents(grade);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable Long id){
        try {
            Student student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().body(null);  // Or return a custom error message
        }
    }



    @PostMapping
    public Student postStudent(@RequestBody Student student){
        return studentService.postStudent(student);
    }

    @PutMapping("/{id}")
    public Student putStudentById(@PathVariable Long id, @RequestBody Student student){
        // TODO endpoint to put data by studentId
        return studentService.postStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        // TODO endpoint to delete student by studentId
    }

}
