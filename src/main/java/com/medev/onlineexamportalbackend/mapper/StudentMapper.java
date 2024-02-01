package com.medev.onlineexamportalbackend.mapper;

import com.medev.onlineexamportalbackend.dto.CreateStudentRequest;
import com.medev.onlineexamportalbackend.dto.UpdateStudentRequest;
import com.medev.onlineexamportalbackend.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student mapToStudent(CreateStudentRequest createStudentRequest){
        Student student = new Student();
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());
        student.setFirstName(createStudentRequest.getFirstName());
        // TODO call here password encryption from security
        student.setPassword(createStudentRequest.getPassword());

        return student;
    }

    public void mapToStudent(UpdateStudentRequest updateStudentRequest, Student student){
        student.setPassword(updateStudentRequest.getPassword());
        student.setContactPhone(updateStudentRequest.getContactPhone());
        student.setFirstName(updateStudentRequest.getFirstName());
        student.setLastName(updateStudentRequest.getLastName());
        student.setEmail(updateStudentRequest.getEmail());


    }

}
