package com.rabbit.app.repository;

import com.rabbit.app.module.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> id(Long id);
}
