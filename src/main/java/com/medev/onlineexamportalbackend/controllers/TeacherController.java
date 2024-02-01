package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.dto.CreateTeacherRequest;
import com.medev.onlineexamportalbackend.dto.StudentCourseDTO;
import com.medev.onlineexamportalbackend.dto.UpdateTeacherRequest;
import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.entity.Teacher;
import com.medev.onlineexamportalbackend.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Teacher createTeacher(@RequestBody CreateTeacherRequest createTeacherRequest){
        return teacherService.createTeacher(createTeacherRequest);
    }

    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @DeleteMapping("/{id}")
    public Teacher deleteTeacherById(@PathVariable Long id){
        return teacherService.deleteTeacherById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Teacher updateTeacherById(@PathVariable Long id, @RequestBody UpdateTeacherRequest updateTeacherRequest){
        return teacherService.updateTeacherById(id, updateTeacherRequest);
    }

    // TODO rework this endpoint
    @PutMapping("/{id}/student/course")
    public Student updateStudentToCourse(@RequestBody StudentCourseDTO studentCourseDTO,@PathVariable Long id){
        return teacherService.updateStudentToCourse(studentCourseDTO,id);
    }

}
