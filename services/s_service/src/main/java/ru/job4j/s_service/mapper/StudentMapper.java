package ru.job4j.s_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.s_service.dto.StudentDto;
import ru.job4j.s_service.model.Student;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(source = "faculty.name", target = "facultyName")
    @Mapping(source = "gradeDiary.number", target = "gradeDiaryNumber")
    StudentDto toDto(Student student);

    List<StudentDto> toDtoList(List<Student> students);
}