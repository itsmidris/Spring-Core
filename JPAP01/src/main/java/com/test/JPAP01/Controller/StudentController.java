package com.test.JPAP01.Controller;

import com.test.JPAP01.Entity.Student;
import com.test.JPAP01.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    // Interview-A class has single variable and using Constructor for dependency injection
    // Do we need @Autowired ?
    // Starting from Spring Framework 4.3,
    // if a Spring-managed bean has only one constructor,
    // Spring will automatically detect it and inject the required dependencies
    // without needing an explicit @Autowired annotation.

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping
    public Student updateStudent(@RequestParam Long id,
                                 @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @PatchMapping
    public Student patchStudent(@RequestParam Long id,
                                @RequestParam String name){
        return studentService.patchStudent(id, name);
    }
}