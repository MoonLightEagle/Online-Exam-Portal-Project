package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.dto.CreateStudentRequest;
import com.medev.onlineexamportalbackend.dto.UpdateStudentRequest;
import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.mapper.StudentMapper;
import com.medev.onlineexamportalbackend.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(IllegalArgumentException::new);

    }

    public List<Student> getStudentsByExamId(Long id) {
        return studentRepository.findByExams(id);
        // TODO fix usage of this
    }

    public Student createStudent(CreateStudentRequest createStudentRequest) {
        return studentRepository.save(studentMapper.mapToStudent(createStudentRequest));
    }

    @Transactional
    public Student updateStudentById(Long id, UpdateStudentRequest updateStudentRequest) {
        Student oldStudent = studentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        studentMapper.mapToStudent(updateStudentRequest,oldStudent);
        return studentRepository.save(oldStudent);
    }


    public Student deleteStudentById(Long id) {
        var oldStudent = studentRepository.findById(id).get();
        studentRepository.deleteById(id);
        return oldStudent;
    }
}
