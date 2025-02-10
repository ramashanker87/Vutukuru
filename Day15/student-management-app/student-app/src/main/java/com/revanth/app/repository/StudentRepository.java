package com.revanth.app.repository;

import com.revanth.app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Long id(Long id);
}
