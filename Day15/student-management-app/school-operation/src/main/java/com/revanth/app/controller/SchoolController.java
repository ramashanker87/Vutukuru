package com.revanth.app.controller;

import com.revanth.app.model.Student;
import com.revanth.app.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolController.class);


    @PostMapping("/save")
    public Student saveStudent(@RequestBody final Student student) throws InterruptedException {
        LOGGER.info("Student data saved to database:");
        return schoolService.saveStudent(student);
    }
    @GetMapping("/read")
    public List<Student> getAllStudents() throws InterruptedException {
        LOGGER.info("Student data fetched from database:");
        return schoolService.getAllStudent();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestParam Long id, @RequestParam int age) throws InterruptedException {
        LOGGER.info("Student data updated from database:");
        return schoolService.updateStudent(id,age);
    }
    @DeleteMapping("/delete")
    public void updateStudent(@RequestParam Long id) throws InterruptedException {
        LOGGER.info("student data deleted from database:");
        schoolService.deleteStudent(id);
    }
}
