package com.revanth.app.repository;

import com.revanth.app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<Student, Long> {
}
