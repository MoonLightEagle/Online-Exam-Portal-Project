package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.dto.CreateGradeRequest;
import com.medev.onlineexamportalbackend.dto.UpdateGradeRequest;
import com.medev.onlineexamportalbackend.entity.Grade;
import com.medev.onlineexamportalbackend.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Grade createGrade(@RequestBody CreateGradeRequest createGradeRequest){
        return gradeService.createGrade(createGradeRequest);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Grade updateGradeById(@PathVariable Long id, @RequestBody UpdateGradeRequest grade){
        return gradeService.updateGradeById(id,grade);
    }

    @DeleteMapping("/{id}")
    public Grade deleteGradeById(@PathVariable Long id){
        return gradeService.deleteGradeById(id);
    }

    @GetMapping
    public List<Grade> getAllGrades(){
        return gradeService.getAllGrades();
    }
}
