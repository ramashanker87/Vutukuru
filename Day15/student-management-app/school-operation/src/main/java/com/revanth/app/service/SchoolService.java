package com.revanth.app.service;

import com.revanth.app.model.Student;
import com.revanth.app.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    public Student saveStudent(Student student) {
        return schoolRepository.save(student);
    }

    public List<Student> getAllStudent() {
        return schoolRepository.findAll();
    }

    public Student updateStudent(Long id, int age) {
        Student student=schoolRepository.getById(id);
        student.setAge(age);
        return schoolRepository.save(student);
    }

    public void deleteStudent(Long id) {
        schoolRepository.deleteById(id);
    }
}
