package com.example.universitymanagmentsystem.controller;

import com.example.universitymanagmentsystem.dto.TeacherDto;
import com.example.universitymanagmentsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/salam")
    public String test(){
        return "TEST";
    }
}
