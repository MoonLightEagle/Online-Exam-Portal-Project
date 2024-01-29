package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.repository.StudentRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudents(Long grade) {
        if (grade!=null){
            return studentRepository.findAllByGrade(grade);
        }else{
            return studentRepository.findAll();
        }

    }



    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();

    }

    public List<Student> getStudentsByExamId(Long id) {
        return studentRepository.findByExams(id);
    }


    public Student postStudent(Student student) {
        return studentRepository.save(student);
    }


    public Student putStudentById(Long id, Student student) {
        Student oldStudent = null;
        if(studentRepository.findById(id).isPresent()){
            oldStudent = studentRepository.findById(id).get();
        }else{
            // TODO need to return sort of error
            return null;
        }
        oldStudent.setEmail(student.getEmail());
        oldStudent.setGrade(student.getGrade());
        oldStudent.setContactPhone(student.getContactPhone());
        oldStudent.setFirstName(student.getFirstName());
        oldStudent.setLastName(student.getLastName());
        return studentRepository.save(oldStudent);

    }


    public Student deleteStudentById(Long id) {
        var oldStudent = studentRepository.findById(id).get();
        studentRepository.deleteById(id);
        return oldStudent;
    }
}
