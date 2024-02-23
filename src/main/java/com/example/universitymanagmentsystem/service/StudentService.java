package com.example.universitymanagmentsystem.service;

import com.example.universitymanagmentsystem.dto.StudentDto;
import com.example.universitymanagmentsystem.entity.Student;
import com.example.universitymanagmentsystem.repository.StudentRepository;
import com.example.universitymanagmentsystem.response.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class StudentService {
    public final StudentRepository studentRepository;
    public StudentDto studentDto;

    public StudentResponse<String> saveStudent(StudentDto dto) {
        Student student = new Student();
        student.setUsername(dto.getName());
        studentRepository.save(student);
        return StudentResponse.success("saved");
    }

    public StudentResponse<String> getPoint(Long id) {
        Optional<Student> optionalStudent = studentRepository.findStudentById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            return StudentResponse.success(student.getPoint().toString());
        } else {
            return StudentResponse.notFound("point not found");
        }
    }
}
