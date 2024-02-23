package com.example.universitymanagmentsystem.controller;

import com.example.universitymanagmentsystem.dto.StudentDto;
import com.example.universitymanagmentsystem.repository.StudentRepository;
import com.example.universitymanagmentsystem.response.StudentResponse;
import com.example.universitymanagmentsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;
    private final StudentRepository repository;

    @PostMapping(value = "/registerStudent")
    public StudentResponse<String> registerStudent(@RequestBody StudentDto student) {
        return service.saveStudent(student);
    }

    @GetMapping(value = "/getPoint/{id}")
    public StudentResponse<String> getPoint(@PathVariable(name = "id") Long id) {
        return service.getPoint(id);
    }
}
