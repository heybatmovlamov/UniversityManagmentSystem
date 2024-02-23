package com.example.universitymanagmentsystem.controller;

import com.example.universitymanagmentsystem.entity.Teacher;
import com.example.universitymanagmentsystem.repository.StudentRepository;
import com.example.universitymanagmentsystem.repository.TeacherRepository;
import com.example.universitymanagmentsystem.response.TeacherResponse;
import com.example.universitymanagmentsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeacherController {
    private  final TeacherService service;

    @PostMapping("/registerTeacher")
    public TeacherResponse<String> registerTeacher(@RequestBody Teacher teacher){
        return service.saveTeacher(teacher);
    }
    @PostMapping("/setPoint/{teacherId}/{studentId}/{point}")
    public TeacherResponse<String> setPoint(@PathVariable(name = "teacherId") Long teacherId,
                                            @PathVariable(name = "studentId") Long studentId,
                                            @PathVariable(name = "point") Long point){
        return service.setPoints(teacherId,studentId,point);
    }
}
