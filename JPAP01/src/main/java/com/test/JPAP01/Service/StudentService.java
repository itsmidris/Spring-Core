package com.test.JPAP01.Service;

import com.test.JPAP01.Entity.Student;
import com.test.JPAP01.Repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    // Interview:
    // Why Constructor Injection is preferred over Field Injection?
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student createStudent(Student student){
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public Student updateStudent(Long id, Student student){

        Student s = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not Found"));

        s.setName(student.getName());
        s.setEmail(student.getEmail());

        return studentRepo.save(s);
    }

    public Student patchStudent(Long id, String name){

        Student s = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not Found"));

        s.setName(name);

        return studentRepo.save(s);
    }
}