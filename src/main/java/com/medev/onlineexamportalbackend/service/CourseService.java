package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.entity.Course;
import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;

    public CourseService(CourseRepository courseRepository, StudentService studentService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
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

    public void addStudentToCourse(Long studentId, Long courseId){
        var course = courseRepository.findById(courseId).get();
        course.getStudents().add(studentService.getStudentById(studentId));
    }
}
