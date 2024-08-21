package ru.job4j.s_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String facultyName;
    private String gradeDiaryNumber;
}