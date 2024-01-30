package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.dto.LoginDTO;
import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {
    //private final LoginRepository loginRepository;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public LoginService(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    public String LoginUser(LoginDTO loginDTO) {

        if(Objects.equals(loginDTO.getRole(), "student")){
            return "successfully login";
        }else if(Objects.equals(loginDTO.getRole(), "teacher")){
            return "successfully login";
        }

        return "login unsuccessful";

    }

    private boolean validateStudent(LoginDTO loginDTO){
        if(Objects.equals(loginDTO.getRole(), "student")){
            var students = studentService.getAllStudents();
            for(Student s:students){
                if(Objects.equals(s.getEmail(), loginDTO.getEmail())){

                    if(Objects.equals(loginDTO.getPassword(), s.getPassword())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean validateTeacher(LoginDTO loginDTO){

        if(Objects.equals(loginDTO.getRole(), "teacher")){
            var teachers = teacherService.getAllTeachers();
            for(Teacher t:teachers){
                if(Objects.equals(t.getEmail(), loginDTO.getEmail())){
                    if(Objects.equals(loginDTO.getPassword(), t.getPassword())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
