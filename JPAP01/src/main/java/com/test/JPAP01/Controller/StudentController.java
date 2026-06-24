package com.test.JPAP01.Controller;

import com.test.JPAP01.Entity.Student;
import com.test.JPAP01.Repo.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    //Interview-A class has single variable and using Constructor for dependency injection
    //Do we need @Autowired ?
    //Starting from Spring Framework 4.3,
    // if a Spring-managed bean has only one constructor,
    // Spring will automatically detect it and inject the required dependencies
    // without needing an explicit @Autowired annotation.

    private final StudentRepo studentRepo;


    public StudentController(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepo.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    @PutMapping
    public Student updateStudent(@RequestParam Long id, @RequestBody Student student){
        Student s = studentRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Student not Found"));
        s.setName(student.getName());
        s.setEmail(student.getEmail());
        return studentRepo.save(s);
    }

    @PatchMapping
    public Student patchStudent(@RequestParam Long id,@RequestParam String name){
        Student s = studentRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Student not Found"));
        s.setName(name);
        return s;
    }
}
