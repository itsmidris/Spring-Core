package com.test.BootP02.controller;

import com.test.BootP02.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/welcome")
    public String dataFetchFromDB(){
        return service.getStudentData();
    }


}
