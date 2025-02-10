package com.revanth.app.controller;

import com.revanth.app.model.Student;
import com.revanth.app.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private final RestTemplate restTemplate;

    public StudentController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Value("${get.receive.url}")
    String receivegetUrl; //http://localhost:10082/receiver/get

    @Value("${post.receive.url}")
    String receivepostUrl; //http://localhost:10082/receiver/post

    @Value("${put.receive.url}")
    String receiveputUrl; //http://localhost:10082/receiver/put

    @Value("${delete.receive.url}")
    String receivedeleteUrl; //http://localhost:10082/receiver/delete


    @Autowired
    private  StudentService studentService ;

//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
    @PostMapping("/save")
    public Student saveStudent(@RequestBody final Student student) {
        return studentService.saveStudent(student);
    }
    @GetMapping("/read")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @PutMapping("/update")
    public Student updateStudent(@RequestParam Long id, @RequestParam int age) {
        return studentService.updateStudent(id,age);
    }
    @DeleteMapping("/dpdate")
    public Student updateStudent(@RequestParam Long id) {
        return studentService.deleteStudent(id);
    }

}
