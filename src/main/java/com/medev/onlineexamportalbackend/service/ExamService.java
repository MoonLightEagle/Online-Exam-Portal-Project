package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.dto.CreateExamRequest;
import com.medev.onlineexamportalbackend.dto.UpdateExamRequest;
import com.medev.onlineexamportalbackend.entity.Exam;
import com.medev.onlineexamportalbackend.entity.Question;
import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.mapper.ExamMapper;
import com.medev.onlineexamportalbackend.repository.ExamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;
    private final ExamMapper examMapper;

    public List<Student> getStudentsByExamId(Long id) {
        return examRepository.findStudentsByExamId(id);
    }

    public void addQuestionToExam(Long id, Question question){
        Exam exam = examRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        // TODO finish here
    }

    public Exam createExam(CreateExamRequest createExamRequest) {
        return examRepository.save(examMapper.mapToExam(createExamRequest));
    }

    public Exam deleteExamById(Long id) {
        Exam oldExam = examRepository.findById(id).get();
        examRepository.deleteById(id);
        return oldExam;
    }

    @Transactional
    public Exam updateExamById(Long id, UpdateExamRequest updateExamRequest) {
        Exam oldExam = examRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        examMapper.mapToExam(updateExamRequest, oldExam);
        return examRepository.save(oldExam);

    }

    public void addQuestionToExam(Question question, Long examId){
        Exam exam = examRepository.findById(examId).get();
        exam.getQuestions().add(question);
    }

    public Exam getExamById(Long id) {
        return examRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
