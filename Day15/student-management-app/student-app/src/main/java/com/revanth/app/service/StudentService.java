package com.revanth.app.service;

import com.revanth.app.model.Student;
import com.revanth.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private  StudentRepository studentRepository;

//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id , int age) {
        Student student=studentRepository.getById(id);
        student.setAge(age);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
         studentRepository.deleteById(id);
    }
}
