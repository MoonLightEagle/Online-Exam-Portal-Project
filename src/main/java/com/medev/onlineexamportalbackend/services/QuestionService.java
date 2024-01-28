package com.medev.onlineexamportalbackend.services;

import com.medev.onlineexamportalbackend.entity.Question;
import com.medev.onlineexamportalbackend.repository.QuestionRepository;
import com.medev.onlineexamportalbackend.service.ExamService;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final ExamService examService;

    public QuestionService(QuestionRepository questionRepository, ExamService examService) {
        this.questionRepository = questionRepository;
        this.examService = examService;
    }

    public Question postQuestionByExamId(Long id, Question question) {
        examService.addQuestionToExam(question,id);
        return questionRepository.save(question);

    }
}
