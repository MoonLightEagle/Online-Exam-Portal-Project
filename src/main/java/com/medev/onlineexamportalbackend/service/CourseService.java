package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.entity.Course;
import com.medev.onlineexamportalbackend.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course postCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course putCourseById(Long id, Course course) {
        var oldCourse = courseRepository.findById(id).get();
        oldCourse.setDescription(course.getDescription());
        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
        return oldCourse;
    }

    public Course deleteCourseById(Long id) {
        var oldCourse = courseRepository.findById(id).get();
        courseRepository.deleteById(id);
        return oldCourse;
    }
}
