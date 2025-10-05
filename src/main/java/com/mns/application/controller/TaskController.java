package com.mns.application.controller;


import com.mns.application.model.Task;
import com.mns.application.model.User;
import com.mns.application.service.TaskService;
import com.mns.application.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.rmi.NotBoundException;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {


    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("")
    public String allTask(Model model) {
       List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "taskList";

    }

    @GetMapping("/{id}")
    public String getTask(Model model, @PathVariable int id) {
        Task task = taskService.findById(id);
        if (task == null) {
            return "error";
        }
        model.addAttribute("task", task);
        return "task";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteById(id);
        return "redirect:/tasks";
    }

    @GetMapping("/create")
    public String addTask(Model model) {
        List<User>users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("task", new Task());

        return "addTask";
    }

    @PostMapping("/add")
    public String createTask(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Integer id, Model model) {
        Task task = taskService.findById(id);
        if (task == null) {
            return "redirect:/tasks";
        }
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("task", task);
        return "addTask";
    }














}
