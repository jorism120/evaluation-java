package com.mns.application.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("")
public class MainController {

    @GetMapping
    public String MainMethod(Model model) {
        model.addAttribute("message","ok");

        return "main";
    }
}
