package ru.job4j.s_service.service;

import ru.job4j.s_service.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto getStudent(long studentId);
    List<StudentDto> getAllStudents();
}
