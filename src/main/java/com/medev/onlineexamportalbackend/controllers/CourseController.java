package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.dto.CreateCourseRequest;
import com.medev.onlineexamportalbackend.dto.UpdateCourseRequest;
import com.medev.onlineexamportalbackend.entity.Course;
import com.medev.onlineexamportalbackend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Course createCourse(@RequestBody CreateCourseRequest createCourseRequest){
        return courseService.createCourse(createCourseRequest);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Course updateCourseById(@PathVariable Long id, @RequestBody UpdateCourseRequest courseRequest){
        return courseService.updateCourseById(id, courseRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable Long id){
        courseService.deleteCourseById(id);
    }
}
