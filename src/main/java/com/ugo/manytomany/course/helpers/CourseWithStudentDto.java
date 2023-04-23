package com.ugo.manytomany.course.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseWithStudentDto {
    private Long id;
    private String name;
    private String professor;
    private String description;
}
