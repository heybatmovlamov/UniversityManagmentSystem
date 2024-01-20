package com.example.universitymanagmentsystem.service;

import com.example.universitymanagmentsystem.dto.TeacherDto;
import com.example.universitymanagmentsystem.entity.Teacher;
import com.example.universitymanagmentsystem.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeacherService  {
    private final TeacherRepository teacherRepository;

    public String saveTeacher(TeacherDto dto){
        Teacher teacher = new Teacher();
        teacher.setName(dto.getName());
        teacher.setSurname(dto.getSurname());
        teacherRepository.save(teacher);
        return "save";
    }

}
