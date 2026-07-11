package com.test.SecurityP04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private UserService service;

    @PostMapping("/addUsers")
    public String addUsers(@RequestBody UserListRequest request) {
        service.saveUsers(request.getUsers());
        return "User added.";
    }

    @GetMapping("/public")
    public String publicMethod() {
        return "This is Public Method";
    }

    @GetMapping("/admin")
    public String adminMethod() {
        return "This is Admin Method";
    }

    @GetMapping("/user")
    public String userMethod() {
        return "This is User Method";
    }
}
