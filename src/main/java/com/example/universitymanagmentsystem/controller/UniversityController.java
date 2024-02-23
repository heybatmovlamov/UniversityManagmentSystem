package com.example.universitymanagmentsystem.controller;


import com.example.universitymanagmentsystem.entity.Student;
import com.example.universitymanagmentsystem.entity.Teacher;
import com.example.universitymanagmentsystem.repository.StudentRepository;
import com.example.universitymanagmentsystem.repository.TeacherRepository;
import com.example.universitymanagmentsystem.response.StudentResponse;
import com.example.universitymanagmentsystem.response.TeacherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class UniversityController {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @GetMapping("/students")
    public StudentResponse<List<Student>> getStudents() {
        List<Student> all = studentRepository.findAll();
        return StudentResponse.success(all);
    }

    @GetMapping("/teachers")
    public TeacherResponse<List<Teacher>> getTeachers() {
        List<Teacher> all = teacherRepository.findAll();
        return TeacherResponse.success(all);
    }
    @GetMapping("/byid/{id}")
    public void byid(@PathVariable Long id) {
        Teacher teacher=teacherRepository.findById(id).orElse(null);

    }


    @DeleteMapping("/deleteTeacher/{id}")
    public TeacherResponse<String> deleteTeacherById(@PathVariable(name = "id") Long id) {
        Optional<Teacher> byId = teacherRepository.findById(id);
        if (byId.isPresent()) {
            teacherRepository.deleteById(id);
            return TeacherResponse.success("deleted");
        }
        return TeacherResponse.notFound("something is wrong");
    }

    @DeleteMapping("/deleteStudent/{id}")
    public StudentResponse<String> deleteStudentById(@PathVariable(name = "id") Long id) {
        studentRepository.deleteById(id);
        return StudentResponse.success("deleted");
    }
}
