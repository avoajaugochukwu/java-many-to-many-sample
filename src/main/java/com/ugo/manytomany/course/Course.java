package com.ugo.manytomany.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ugo.manytomany.student.Student;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("students")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String professor;

    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
}
