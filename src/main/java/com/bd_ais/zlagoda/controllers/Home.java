package com.bd_ais.zlagoda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/home")
@Controller
@RequestMapping("/home")
public class Home {

    @GetMapping
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/manager")
    public String getHomePage2() {
        return "admin/adminPanel";
    }
}
