package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.entity.Teacher;
import com.medev.onlineexamportalbackend.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher postTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher deleteTeacherById(Long id) {
        var deletedTeacher = teacherRepository.findById(id).get();

        teacherRepository.deleteById(id);

        return deletedTeacher;
    }
}
