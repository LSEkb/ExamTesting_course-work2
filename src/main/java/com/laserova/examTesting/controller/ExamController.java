package com.laserova.examTesting.controller;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.service.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController (ExaminerService examinerService){
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Set<Question> getQuestions(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }
}
