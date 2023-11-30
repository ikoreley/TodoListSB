package ik.koresh.todolistsb.controllers;

import ik.koresh.todolistsb.models.Status;
import ik.koresh.todolistsb.models.Task;
import ik.koresh.todolistsb.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    private final TasksService tasksService;

    @Autowired
    public IndexController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("todolist", tasksService.findAll());
        model.addAttribute("status", Status.values());

        model.addAttribute("tasks", new Task()); // @ModelAttribute("task") Task task
        return "index";
    }
}
