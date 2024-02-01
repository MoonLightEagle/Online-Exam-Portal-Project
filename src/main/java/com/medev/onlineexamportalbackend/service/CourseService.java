package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.dto.CreateCourseRequest;
import com.medev.onlineexamportalbackend.dto.UpdateCourseRequest;
import com.medev.onlineexamportalbackend.entity.Course;
import com.medev.onlineexamportalbackend.mapper.CourseMapper;
import com.medev.onlineexamportalbackend.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;
    private final CourseMapper courseMapper;

    public Course createCourse(CreateCourseRequest createCourseRequest) {
        return courseRepository.save(courseMapper.mapToCourse(createCourseRequest));
    }
    @Transactional
    public Course updateCourseById(Long id, UpdateCourseRequest updateCourseRequest) {
        Course oldCourse = courseRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        courseMapper.mapToCourse(updateCourseRequest,oldCourse);
        return courseRepository.save(oldCourse);
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    public void addStudentToCourse(Long studentId, Long courseId){
        Course course = courseRepository.findById(courseId).orElseThrow(IllegalArgumentException::new);
        course.getStudents().add(studentService.getStudentById(studentId));
    }
}
