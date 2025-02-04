package com.revanth.app.service;

import com.revanth.app.model.Student;
import com.revanth.app.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentService service;

    @Test
    void testSaveStudent() {
        Student student = new Student("John", "ABC School", 18, "M");
        when(repository.save(any(Student.class))).thenReturn(student);
        Student savedStudent = service.saveStudent(student);
        assertNotNull(savedStudent);
        assertEquals("John", savedStudent.getName());
    }

    @Test
    void testGetAllStudents() {
        List<Student> students = Arrays.asList(new Student("John", "ABC School", 18, "M"));
        when(repository.findAll()).thenReturn(students);
        List<Student> result = service.getAllStudents();
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }
}

