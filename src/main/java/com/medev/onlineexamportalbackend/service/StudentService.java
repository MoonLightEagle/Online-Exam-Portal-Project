package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.entity.Student;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface StudentService {

    public List<Student> getAllStudents(Long grade);

    public Student getStudentById( Long id) throws BadRequestException;

    public List<Student> getStudentsByExamId( Long id);


    public Student postStudent( Student student);


    public Student putStudentById( Long id,  Student student);


    public void deleteStudentById( Long id);
}
