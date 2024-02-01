package com.medev.onlineexamportalbackend.mapper;

import com.medev.onlineexamportalbackend.dto.CreateCourseRequest;
import com.medev.onlineexamportalbackend.dto.UpdateCourseRequest;
import com.medev.onlineexamportalbackend.entity.Course;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public Course mapToCourse(CreateCourseRequest createCourseRequest){
        Course course = new Course();
        course.setName(createCourseRequest.getName());
        course.setDescription(createCourseRequest.getDescription());
        return course;
    }

    public void mapToCourse(UpdateCourseRequest updateCourseRequest, Course course){
        course.setName(updateCourseRequest.getName());
        course.setDescription(updateCourseRequest.getDescription());
        course.setGrade(updateCourseRequest.getGrade());
        course.setTeacher(updateCourseRequest.getTeacher());
        course.setStudents(updateCourseRequest.getStudentList());

    }




}
