package com.test.LearnThymeleaf.mapper;

import com.test.LearnThymeleaf.dto.StudentRequest;
import com.test.LearnThymeleaf.dto.StudentResponse;
import com.test.LearnThymeleaf.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentRequest request);
    StudentResponse toResponse(Student student);
}
