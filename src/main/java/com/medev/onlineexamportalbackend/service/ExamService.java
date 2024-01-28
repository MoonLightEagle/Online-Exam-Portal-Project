package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public List<Student> getStudentsByExamId(Long id) {
        return examRepository.findStudentsByExamId(id);
    }
}
