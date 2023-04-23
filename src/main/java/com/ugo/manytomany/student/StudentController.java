package com.ugo.manytomany.student;

import com.ugo.manytomany.exceptions.ValidationExceptionHandler;
import com.ugo.manytomany.student.helpers.StudentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody @Valid StudentRequest studentRequest) {
        studentService.createStudent(studentRequest);
    }

    @PostMapping("/{studentId}/course/{courseId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.addCourseToStudent(studentId, courseId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ValidationExceptionHandler.handleValidationExceptions(ex);
    }

}
