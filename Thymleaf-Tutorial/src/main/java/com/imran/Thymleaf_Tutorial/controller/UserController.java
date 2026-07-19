package com.imran.Thymleaf_Tutorial.controller;


import com.imran.Thymleaf_Tutorial.controller.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    //handler method to handle variable-expression request

    @GetMapping("variable-expression")
    public String variableExpression(Model model) {
        User user = new User("Ramesh", "ramesh@gmail.com","ADMIN", "Male" );
        model.addAttribute("user", user);
        return "variable-expression";
    }

    //handler method to handle selection expression.
    @GetMapping("selection-expression")
    public String selectionExpression(Model model) {
        User user = new User("Imran", "Imran@gmail.com", "ADMIN", "MALE");
        model.addAttribute("user", user);

        return "selection-expression";
    }

    //handler method to handle message expression request
    @GetMapping("message-expression")
    public String messageExpression() {
        return "message-expression";
    }

    //handler method to handle link expressions
    @GetMapping("link-expression")
    public String linkExpression(Model model) {
        model.addAttribute("id",1);
        return "link-expression";
    }

    //Handler method to handle fragment expression
    @GetMapping("fragment-expression")
    public String fragmentExpression() {
        return "fragment-expression";
    }

    @GetMapping("/users")
    public String users(Model model) {
        User admin = new User("Admin", "admin@gmail.com", "ADMIN", "Male");
        User mubarak = new User("Mubarak", "Mubarak@gmail.com", "User", "Male");
        User Saud = new User("Saud", "Saud@gmail.com", "User", "Female");

        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(mubarak);
        users.add(Saud);
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/if-unless")
    public String ifUnless(Model model) {
        User admin = new User("Admin", "admin@gmail.com", "ADMIN", "Male");
        User mubarak = new User("Mubarak", "Mubarak@gmail.com", "USER", "Male");
        User Saud = new User("Saud", "Saud@gmail.com", "USER", "Female");

        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(mubarak);
        users.add(Saud);
        model.addAttribute("users",users);
        return "if-unless";
    }

    @GetMapping("/switch-case")
    public String switchCase(Model model) {
        User user = new User(
                "Imran", "Imran@gmail.com", "ADMIN","Male"
        );
        model.addAttribute("user",user);
        return "switch-case";
    }
}
