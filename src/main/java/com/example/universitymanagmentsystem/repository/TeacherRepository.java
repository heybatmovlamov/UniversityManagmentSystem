package com.example.universitymanagmentsystem.repository;

import com.example.universitymanagmentsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
      Optional<Teacher> findTeacherByUsername(String username);
}
