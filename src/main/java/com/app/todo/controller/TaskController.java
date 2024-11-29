package com.app.todo.controller;

import com.app.todo.Service.TaskService;
import com.app.todo.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model) {

        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String addTask(@RequestParam String title) {
        taskService.addTask(title);
        return "redirect:/task";
    }
}
