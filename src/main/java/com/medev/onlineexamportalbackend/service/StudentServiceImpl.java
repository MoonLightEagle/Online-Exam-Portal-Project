package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.repository.StudentRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents(Long grade) {
        if (grade!=null){
            return studentRepository.findAllByGrade(grade);
        }else{
            return studentRepository.findAll();
        }

    }


    @Override
    public Student getStudentById(Long id) throws BadRequestException {
        return studentRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Student with ID " + id + " not found"));
    }
    @Override
    public List<Student> getStudentsByExamId(Long id) {
        return studentRepository.findByExams(id);
    }

    @Override
    public Student postStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
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
        return oldStudent;

    }

    @Override
    public void deleteStudentById(Long id) {

    }
}
