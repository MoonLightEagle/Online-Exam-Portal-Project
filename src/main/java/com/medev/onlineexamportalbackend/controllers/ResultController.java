package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.dto.AnswerDTO;
import com.medev.onlineexamportalbackend.entity.Result;
import com.medev.onlineexamportalbackend.service.ResultService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }


    @PostMapping("/exam/{examId}/student/{studentId}")
    public Result postSubmitResult(@PathVariable Long examId, @PathVariable Long studentId, @RequestBody AnswerDTO answerDTO){
        return resultService.postSubmitResult(examId,studentId,answerDTO);

    }

}
