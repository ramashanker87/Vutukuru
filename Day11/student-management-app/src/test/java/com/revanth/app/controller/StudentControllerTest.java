package com.revanth.app.controller;

import com.revanth.app.model.Student;
import com.revanth.app.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveStudent() {
        Student student = new Student("John", "ABC School", 18, "M");
        when(studentService.saveStudent(any(Student.class))).thenReturn(student);

        Student result = studentController.saveStudent(student);

        assertNotNull(result);
        assertEquals("John", result.getName());
        verify(studentService, times(1)).saveStudent(any(Student.class));
    }

    @Test
    void testGetAllStudents() {
        Student student = new Student("John", "ABC School", 18, "M");
        when(studentService.getAllStudents()).thenReturn(List.of(student));

        List<Student> result = studentController.getAllStudents();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getName());
        verify(studentService, times(1)).getAllStudents();
    }
}
