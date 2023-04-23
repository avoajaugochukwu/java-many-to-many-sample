package com.ugo.manytomany.student;

import com.ugo.manytomany.course.Course;
import com.ugo.manytomany.course.CourseRepository;
import com.ugo.manytomany.student.helpers.StudentRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final Validator validator;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }
    public void createStudent(StudentRequest studentRequest) {
        Set<ConstraintViolation<StudentRequest>> violations = validator.validate(studentRequest);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        Student student = Student.builder()
                .name(studentRequest.name())
                .studentId(studentRequest.studentId())
//                .courses(studentRequest.courses())
                .build();
        studentRepository.save(student);
    }

    public void addCourseToStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course not found"));

        student.getCourses().add(course);
        studentRepository.save(student);
    }
}
