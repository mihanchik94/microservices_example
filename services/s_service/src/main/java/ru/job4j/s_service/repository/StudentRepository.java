package ru.job4j.s_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.s_service.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}