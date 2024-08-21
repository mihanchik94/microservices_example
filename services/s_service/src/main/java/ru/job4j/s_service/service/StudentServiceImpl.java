package ru.job4j.s_service.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.s_service.dto.StudentDto;
import ru.job4j.s_service.mapper.StudentMapper;
import ru.job4j.s_service.model.Student;
import ru.job4j.s_service.producer.AllStudentsProducer;
import ru.job4j.s_service.producer.StudentByIdProducer;
import ru.job4j.s_service.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final AllStudentsProducer allStudentsProducer;
    private final StudentByIdProducer studentByIdProducer;


    @Override
    public StudentDto getStudent(long studentId) {
        StudentDto studentDto = studentMapper.toDto(findById(studentId));
        studentByIdProducer.publish(studentDto);
        log.info("Студент {} отправлен в kafka", studentDto);
        return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<StudentDto> result = studentMapper.toDtoList(studentRepository.findAll());
        allStudentsProducer.publish(result);
        log.info("список студентов {} отправлен в kafka", result);
        return result;
    }

    private Student findById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Студент с id = %d не найден", id)));
    }
}