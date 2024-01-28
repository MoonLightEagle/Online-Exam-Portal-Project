package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.entity.Student;
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

    public Teacher putTeacherById(Long id, Teacher teacher) {
        Teacher oldTeacher = null;
        if(teacherRepository.findById(id).isPresent()){
            oldTeacher = teacherRepository.findById(id).get();
        }else{
            // TODO need to return sort of error
            return null;
        }
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setGrade(teacher.getGrade());
        oldTeacher.setContactPhone(teacher.getContactPhone());
        oldTeacher.setFirstName(teacher.getFirstName());
        oldTeacher.setLastName(teacher.getLastName());
        return teacherRepository.save(oldTeacher);
    }
}
