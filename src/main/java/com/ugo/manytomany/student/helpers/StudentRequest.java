package com.ugo.manytomany.student.helpers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentRequest (
        @NotBlank(message = "Name must not be blank") String name,
        @NotNull(message = "StudentId must not be null") Integer studentId
//        List<Course> courses
) {
}
