package com.medev.onlineexamportalbackend.mapper;

import com.medev.onlineexamportalbackend.dto.CreateTeacherRequest;
import com.medev.onlineexamportalbackend.dto.UpdateTeacherRequest;
import com.medev.onlineexamportalbackend.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public Teacher mapToTeacher(CreateTeacherRequest createTeacherRequest) {
        Teacher teacher = new Teacher();
        teacher.setEmail(createTeacherRequest.getEmail());
        teacher.setFirstName(createTeacherRequest.getFirstName());
        teacher.setLastName(createTeacherRequest.getLastName());
        // TODO encrypt password here
        teacher.setPassword(createTeacherRequest.getPassword());
        return teacher;
    }

    public void mapToTeacher(UpdateTeacherRequest updateTeacherRequest, Teacher teacher) {
        teacher.setEmail(updateTeacherRequest.getEmail());
        teacher.setFirstName(updateTeacherRequest.getFirstName());
        teacher.setLastName(updateTeacherRequest.getLastName());
        // TODO encrypt password here
        teacher.setPassword(updateTeacherRequest.getPassword());
        teacher.setContactPhone(updateTeacherRequest.getContactPhone());
    }
}
