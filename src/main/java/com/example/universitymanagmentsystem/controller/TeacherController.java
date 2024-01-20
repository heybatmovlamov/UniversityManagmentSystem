package com.example.universitymanagmentsystem.controller;

import com.example.universitymanagmentsystem.dto.TeacherDto;
import com.example.universitymanagmentsystem.entity.Teacher;
import com.example.universitymanagmentsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeacherController {
    private  final TeacherService service;

    @PostMapping("/addToTeacher")
    public String save(@RequestBody TeacherDto teacherDto){
        return service.saveTeacher(teacherDto);
    }
    @GetMapping("/s")
    public String test(){
        return "TEST";
    }
}
