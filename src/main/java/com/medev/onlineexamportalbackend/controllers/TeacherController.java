package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.dto.StudentCourseDTO;
import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.entity.Teacher;
import com.medev.onlineexamportalbackend.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public Teacher postTeacher(@RequestBody Teacher teacher){
        return teacherService.postTeacher(teacher);
    }

    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @DeleteMapping("/{id}")
    public Teacher deleteTeacherById(@PathVariable Long id){
        return teacherService.deleteTeacherById(id);
    }

    @PutMapping("/{id}")
    public Teacher putTeacherById(@PathVariable Long id, @RequestBody Teacher teacher){
        return teacherService.putTeacherById(id, teacher);
    }

    @PostMapping("/{id}/student/course")
    public Student postStudentToCourse(@RequestBody StudentCourseDTO studentCourseDTO,@PathVariable Long id){
        return teacherService.postStudentToCourse(studentCourseDTO,id);
    }

}
