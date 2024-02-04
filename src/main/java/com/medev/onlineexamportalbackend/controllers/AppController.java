package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.entity.Grade;
import com.medev.onlineexamportalbackend.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppController {
    private final GradeService gradeService;
    @GetMapping("/home")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/admin")
    public String viewAdminPage(){
        return "this is admin page";
    }
    @GetMapping("/admin/grades")
    public List<Grade> viewGradesPage(){

        return gradeService.getAllGrades();

    }
    @GetMapping("/admin/courses")
    public String viewCoursesPage(){
        return "this is courses page";
    }

    @GetMapping("/admin/students")
    public String viewStudentPage(){
        return "here is students page";
    }

    @GetMapping("/admin/teachers")
    public String viewTeachersPage(){
        return "here is students page";
    }
}
