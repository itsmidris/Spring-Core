package com.test.SecurityP02.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @GetMapping("/contact")
    public String contactus() {
        return "Hello ji, contact us at : 625486";
    }

    @GetMapping("/transfer")
    public String transfer() {
        return "Money transfer initiated";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome Admin Ji.";
    }

    @GetMapping("/about")
    public String about() {
        return "This is Imran... Learning Spring Security";
    }

}
