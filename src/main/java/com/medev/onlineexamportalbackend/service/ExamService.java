package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.entity.Exam;
import com.medev.onlineexamportalbackend.entity.Question;
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

    public void addQuestionToExam(Long id, Question question){
        var exam = examRepository.findById(id);

    }

    public Exam postExam(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam deleteExamById(Long id) {
        var oldExam = examRepository.findById(id).get();
        examRepository.deleteById(id);
        return oldExam;
    }

    public Exam putExamById(Long id, Exam exam) {
        var oldExam = examRepository.findById(id).get();
        oldExam.setGradeId(exam.getId());
        oldExam.setName(exam.getName());
        oldExam.setTeacherId(exam.getTeacherId());
        examRepository.save(oldExam);
        return oldExam;

    }

    public void addQuestionToExam(Question question, Long examId){
        var exam = examRepository.findById(examId).get();
        exam.getQuestions().add(question);
    }
}
