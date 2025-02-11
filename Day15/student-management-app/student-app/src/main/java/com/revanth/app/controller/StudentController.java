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
    @Autowired
    private  RestTemplate restTemplate;

    @Value("${get.receive.url}")
    private String receivegetUrl; //http://localhost:10082/student/get

    @Value("${post.receive.url}")
    private String receivepostUrl; //http://localhost:10082/student/post

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
        ResponseEntity<String> response
                = restTemplate.exchange(receivegetUrl,HttpMethod.GET, null,String.class);
        LOGGER.info(response.getStatusCode().toString());
        LOGGER.info(response.getBody());
        return studentService.saveStudent(student);
    }
    @GetMapping("/read")
    public List<Student> getAllStudents() {
        ResponseEntity<String> response
                = restTemplate.exchange(receivegetUrl,HttpMethod.GET, null,String.class);
        LOGGER.info(response.getStatusCode().toString());
        LOGGER.info(response.getBody());
        return studentService.getAllStudents();
    }
    @PutMapping("/update")
    public Student updateStudent(@RequestParam Long id, @RequestParam int age) {
        ResponseEntity<String> response
                = restTemplate.exchange(receivegetUrl,HttpMethod.GET, null,String.class);
        LOGGER.info(response.getStatusCode().toString());
        LOGGER.info(response.getBody());
        return studentService.updateStudent(id,age);
    }
    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam Long id) {
        ResponseEntity<String> response
                = restTemplate.exchange(receivegetUrl,HttpMethod.GET, null,String.class);
        LOGGER.info(response.getStatusCode().toString());
        LOGGER.info(response.getBody());
         studentService.deleteStudent(id);
    }

}
