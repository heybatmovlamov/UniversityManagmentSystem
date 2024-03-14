package com.example.universitymanagmentsystem.service;

import com.example.universitymanagmentsystem.entity.Teacher;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {
    public String teacher_role  = "ROLE_ADMIN";
   public static String addRole(){
       Teacher teacher = new Teacher();
       teacher.setRole("ADMIN");
       return "role setted";
   }
}
