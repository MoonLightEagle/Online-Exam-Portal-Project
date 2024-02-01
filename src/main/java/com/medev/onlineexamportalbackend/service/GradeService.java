package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.dto.CreateGradeRequest;
import com.medev.onlineexamportalbackend.dto.UpdateGradeRequest;
import com.medev.onlineexamportalbackend.entity.Grade;
import com.medev.onlineexamportalbackend.mapper.GradeMapper;
import com.medev.onlineexamportalbackend.repository.GradeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;
    private final GradeMapper gradeMapper;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }
    public Grade createGrade(CreateGradeRequest createGradeRequest) {
        return gradeRepository.save(gradeMapper.mapToGrade(createGradeRequest));
    }
    @Transactional
    public Grade updateGradeById(Long id, UpdateGradeRequest updateGradeRequest) {
        Grade oldGrade = gradeRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        gradeMapper.mapToGrade(updateGradeRequest,oldGrade);
        return gradeRepository.save(oldGrade);
    }

    public Grade deleteGradeById(Long id) {
        var oldGrade = gradeRepository.findById(id).get();
        gradeRepository.deleteById(id);
        return oldGrade;
    }


}
