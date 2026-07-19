package com.test.LearnThymeleaf.service.serviceimpl;

import com.test.LearnThymeleaf.dto.StudentRequest;
import com.test.LearnThymeleaf.dto.StudentResponse;
import com.test.LearnThymeleaf.entity.Student;
import com.test.LearnThymeleaf.mapper.StudentMapper;
import com.test.LearnThymeleaf.repository.StudentRepository;
import com.test.LearnThymeleaf.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponse createStudent(StudentRequest request) {
        Student student = studentMapper.toEntity(request);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponse(savedStudent);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponse)
                .toList();

    }

    @Override
    public StudentResponse getStudentById(Long id) {
        return null;
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
