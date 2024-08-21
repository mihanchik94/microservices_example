package ru.job4j.s_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "grade_diaries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false, unique = true, length = 16)
    private String number;

    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}