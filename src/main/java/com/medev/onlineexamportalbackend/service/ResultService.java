package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.dto.AnswerDTO;
import com.medev.onlineexamportalbackend.entity.Question;
import com.medev.onlineexamportalbackend.entity.Result;
import com.medev.onlineexamportalbackend.repository.ResultRepository;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
    private final ResultRepository resultRepository;
    private  final ExamService examService;

    public ResultService(ResultRepository resultRepository, ExamService examService) {
        this.resultRepository = resultRepository;
        this.examService = examService;
    }

    public Result postSubmitResult(Long examId, Long studentId, AnswerDTO answerDTO) {
        Result result = new Result();
        result.setExamId(examId);
        result.setStudentId(studentId);


        result.setMaxPoints(getMaxPointsFromExam(examId));
        result.setPercentage(getPercentageFromAnswers(examId,answerDTO));
        if(result.getPercentage()>=51f){
            result.setFailed(false);
        }else{
            result.setFailed(true);
        }
        return resultRepository.save(result);

    }

    private Long getMaxPointsFromExam(Long examId){
        Long maxPoints= 0L;
        for (Question q :examService.getExamById(examId).getQuestions()){
            maxPoints+= q.getPoints();
        }
        return maxPoints;
    }

    private float getPercentageFromAnswers(Long examId, AnswerDTO answerDTO){
        long pointsScored=0;
        long maxPoints=0;
        for(int i =0;i<answerDTO.getAnswersIds().size();i++){
            maxPoints+=examService.getExamById(examId).getQuestions().get(i).getPoints();
            if(examService.getExamById(examId).getQuestions().get(i).getAnswerId() == answerDTO.getAnswersIds().get(i)){
                pointsScored+=examService.getExamById(examId).getQuestions().get(i).getPoints();
            }
        }
        return (float) pointsScored /maxPoints*100;

    }

}
