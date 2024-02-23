package com.example.universitymanagmentsystem.repository;

import com.example.universitymanagmentsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentById(Long id);

//    @Query("SELECT s.name AS name, s.point AS point FROM student s")
//    List<StudentProjection> findAllProjections();
}