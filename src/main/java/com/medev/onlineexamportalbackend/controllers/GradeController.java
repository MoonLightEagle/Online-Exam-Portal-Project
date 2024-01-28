package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.entity.Grade;
import com.medev.onlineexamportalbackend.service.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping
    public Grade postGrade(@RequestBody Grade grade){
        return gradeService.postGrade(grade);
    }

    @PutMapping("/{id}")
    public Grade putGradeById(@PathVariable Long id, @RequestBody Grade grade){
        return gradeService.putGradeById(id,grade);
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
