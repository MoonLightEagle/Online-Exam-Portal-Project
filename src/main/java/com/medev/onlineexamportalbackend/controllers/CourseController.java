package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.entity.Course;
import com.medev.onlineexamportalbackend.service.CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course postCourse(@RequestBody Course course){
        return courseService.postCourse(course);
    }

    @PutMapping("/{id}")
    public Course putCourseById(@PathVariable Long id, @RequestBody Course course){
        return  courseService.putCourseById(id, course);
    }

    @DeleteMapping("/{id}")
    public Course deleteCourseById(@PathVariable Long id){
        return courseService.deleteCourseById(id);
    }
}
