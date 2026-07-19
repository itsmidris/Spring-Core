package com.imran.Thymleaf_Tutorial.controller;


import com.imran.Thymleaf_Tutorial.controller.model.User;
import org.springframework.boot.Banner;
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
}
