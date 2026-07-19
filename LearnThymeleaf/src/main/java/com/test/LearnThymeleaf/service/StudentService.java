package com.test.LearnThymeleaf.service;

import com.test.LearnThymeleaf.dto.StudentRequest;
import com.test.LearnThymeleaf.dto.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse createStudent(StudentRequest request);
    List<StudentResponse> getAllStudents();
    StudentResponse getStudentById(Long id);
    StudentResponse updateStudent(Long id, StudentRequest request);
    void delete(Long id);
}
