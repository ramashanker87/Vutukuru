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

    public Student updateStudent(Long Id , int age) {
        Student student=studentRepository.getById(id);
        student
    }
    public Patient updatePatientHospital(Long id, String newHospitalName) {
        Patient patient=patientRepository.getById(id);
        patient.setHospitalName(newHospitalName);
        return patientRepository.save(patient);
    }

    public Student deleteStudent(String name) {
    }
}
