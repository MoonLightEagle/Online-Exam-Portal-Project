package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.entity.Grade;
import com.medev.onlineexamportalbackend.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public Grade postGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade putGradeById(Long id, Grade grade) {
        var oldGrade = gradeRepository.findById(id).get();
        oldGrade.setName(grade.getName());
        oldGrade.setDescription(grade.getDescription());
        gradeRepository.save(oldGrade);
        return oldGrade;
    }

    public Grade deleteGradeById(Long id) {
        var oldGrade = gradeRepository.findById(id).get();
        gradeRepository.deleteById(id);
        return oldGrade;
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }
}
