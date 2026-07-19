package com.imran.Thymleaf_Tutorial.controller;

import com.imran.Thymleaf_Tutorial.controller.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class FormController {

    //Handler method to handle user registration page request
    @GetMapping("register")
    public String userRegistrationPage(Model model){

        //Empty UserForm Model object to store form data
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        List<String> listProfession = Arrays.asList("Developer","Tester","Architect");
        model.addAttribute("listProfession", listProfession);

        return "register-form";
    }

    @PostMapping("/register/save")
    public String saveUser(@ModelAttribute("userForm") UserForm userForm, Model model) {

        // Print data in console
        System.out.println("Name: " + userForm.getName());
        System.out.println("Email: " + userForm.getEmail());
        System.out.println("Password: " + userForm.getPassword());
        System.out.println("Gender: " + userForm.getGender());
        System.out.println("Profession: " + userForm.getProfession());
        System.out.println("Address: " + userForm.getAddress());

        // Send submitted data to success page
        model.addAttribute("userForm", userForm);

        return "success";
    }
}
