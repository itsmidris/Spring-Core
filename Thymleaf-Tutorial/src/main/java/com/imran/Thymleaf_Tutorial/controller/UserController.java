package com.imran.Thymleaf_Tutorial.controller;


import com.imran.Thymleaf_Tutorial.controller.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    //handler method to handle variable-expression request

    @GetMapping("variable-expression")
    public String variableExpression(Model model) {
        User user = new User("Ramesh", "ramesh@gmail.com","ADMIN", "Male" );
        model.addAttribute("user", user);
        return "variable-expression";
    }
}
