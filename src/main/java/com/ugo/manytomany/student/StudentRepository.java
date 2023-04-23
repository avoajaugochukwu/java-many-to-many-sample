package com.ugo.manytomany.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.courses")
    List<Student> fetchAllWithCourses();
}
