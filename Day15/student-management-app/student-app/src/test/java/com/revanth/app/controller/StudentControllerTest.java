package com.revanth.app.controller;

import com.revanth.app.model.Student;
import com.revanth.app.service.StudentService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private Student student;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student("John", "ABC School", 18, "M");
        when(studentService.saveStudent(any(Student.class))).thenReturn(student);
        Student result = studentController.saveStudent(student);
        assertNotNull(result);
        assertEquals("John", result.getName());
        verify(studentService, times(1)).saveStudent(any(Student.class));
    }

    @Test
    public void testGetAllStudents() {
        Student student = new Student("John", "ABC School", 18, "M");
        when(studentService.getAllStudents()).thenReturn(List.of(student));
        List<Student> result = studentController.getAllStudents();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getName());
        verify(studentService, times(1)).getAllStudents();
    }

    @Test
    public void testUpdateStudent() {
        Long id = 1L;
        int newAge=20;
        studentController.updateStudent(id, newAge);
        verify(studentService, times(1)).updateStudent(id, newAge);
    }

    @Test
    public void testDeleteStudent() {
        Long id = 1L;
        studentController.deleteStudent(id);
    }
}
