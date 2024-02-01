package com.medev.onlineexamportalbackend.mapper;

import com.medev.onlineexamportalbackend.dto.CreateGradeRequest;
import com.medev.onlineexamportalbackend.dto.UpdateGradeRequest;
import com.medev.onlineexamportalbackend.entity.Grade;
import org.springframework.stereotype.Component;

@Component
public class GradeMapper {
    public Grade mapToGrade(CreateGradeRequest createGradeRequest){
        Grade grade = new Grade();
        grade.setName(createGradeRequest.getName());
        grade.setDescription(createGradeRequest.getDescription());
        return grade;
    }
    public void mapToGrade(UpdateGradeRequest updateGradeRequest, Grade grade){
        grade.setDescription(updateGradeRequest.getDescription());
        grade.setCourses(updateGradeRequest.getCourses());
        grade.setTeachers(updateGradeRequest.getTeachers());
        grade.setStudents(updateGradeRequest.getStudents());
        grade.setName(updateGradeRequest.getName());
    }
}
