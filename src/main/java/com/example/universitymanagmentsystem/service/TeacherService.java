package com.example.universitymanagmentsystem.service;

import com.example.universitymanagmentsystem.dto.TeacherDto;
import com.example.universitymanagmentsystem.entity.Student;
import com.example.universitymanagmentsystem.entity.Teacher;
import com.example.universitymanagmentsystem.exception.TeacherNotFoundException;
import com.example.universitymanagmentsystem.repository.StudentRepository;
import com.example.universitymanagmentsystem.repository.TeacherRepository;
import com.example.universitymanagmentsystem.response.TeacherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final UniversityService universityService;
    private final PasswordEncoder passwordEncoder;
    public TeacherResponse<String> saveTeacher(Teacher teacher) {
        teacher.setUsername(teacher.getUsername());
        teacher.setRole(universityService.teacher_role);
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        teacherRepository.save(teacher);
        return TeacherResponse.success("saved");
    }

    public TeacherResponse<List<Teacher>> showAllTeacher() {
        List<Teacher> all = teacherRepository.findAll();
        final TeacherResponse<List<Teacher>> data;
        if (all.isEmpty()) {

            data = TeacherResponse.notFound(all);
            TeacherResponse.notFound(new TeacherNotFoundException());

        } else data = TeacherResponse.success(all);

        return data;
    }

    public TeacherResponse<String> setPoints(Long teacherId, Long studentId, Long points) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalTeacher.isPresent() && optionalStudent.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            Student student = optionalStudent.get();

            student.setTeacher(teacher);
            student.setPoint(points);

            // Save the updated student
            studentRepository.save(student);
            return TeacherResponse.success("point added");
        } else {
            return TeacherResponse.notFound("teacher or student is not found");
        }
    }

}
