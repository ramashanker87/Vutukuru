package com.revanth.app.repository;

import com.revanth.app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> id(Long id);


}
