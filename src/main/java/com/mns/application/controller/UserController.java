package com.mns.application.controller;


import com.mns.application.model.Task;
import com.mns.application.model.User;
import com.mns.application.service.TaskService;
import com.mns.application.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String allUsers(Model model) {
       List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "userList";

    }

    @GetMapping("/{id}")
    public String getUser(Model model, @PathVariable int id) {
        User user = userService.findById(id);
        if (user == null) {
            return "error";
        }
        model.addAttribute("user", user);
        return "user";
    }






}
