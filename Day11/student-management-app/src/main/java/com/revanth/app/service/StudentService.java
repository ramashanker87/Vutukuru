package com.revanth.app.service;

import com.revanth.app.model.Student;
import com.revanth.app.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
