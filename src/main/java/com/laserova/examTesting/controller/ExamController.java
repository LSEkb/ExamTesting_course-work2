package com.laserova.examTesting.controller;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/java/")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController (ExaminerService examinerService){
        this.examinerService = examinerService;
    }

    @GetMapping("/ticket")
    public Set<Question> getQuestions(@RequestParam int amount){
        return examinerService.getQuestions(amount);
    }
}
