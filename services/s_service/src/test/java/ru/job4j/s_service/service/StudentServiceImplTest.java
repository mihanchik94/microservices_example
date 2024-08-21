package ru.job4j.s_service.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.job4j.s_service.dto.StudentDto;
import ru.job4j.s_service.mapper.StudentMapper;
import ru.job4j.s_service.model.Student;
import ru.job4j.s_service.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
    private static final long STUDENT_ID = 1L;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;
    private StudentDto studentDto;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .id(STUDENT_ID)
                .build();
        studentDto = StudentDto.builder()
                .id(student.getId())
                .build();
    }

    @Test
    public void whenGetStudentThenException() {
        when(studentRepository.findById(STUDENT_ID)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> studentService.getStudent(STUDENT_ID));
    }

    @Test
    public void whenGetStudentThenStudentDto() {
        when(studentRepository.findById(STUDENT_ID)).thenReturn(Optional.of(student));
        when(studentMapper.toDto(any())).thenReturn(studentDto);
        StudentDto actual = studentService.getStudent(STUDENT_ID);
        assertEquals(actual, studentDto);
    }

    @Test
    public void getAllStudentsThenList() {
        when(studentRepository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(studentService.getAllStudents().isEmpty());
    }
}