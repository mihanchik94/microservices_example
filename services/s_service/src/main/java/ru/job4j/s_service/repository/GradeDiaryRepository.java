package ru.job4j.s_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.s_service.model.GradeDiary;

public interface GradeDiaryRepository extends JpaRepository<GradeDiary, Long> {
}
