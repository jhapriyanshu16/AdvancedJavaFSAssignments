package org.example.springmvcprj.controller;

import org.example.springmvcprj.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/student")
    public String submitStudent(@ModelAttribute Student student, Model model) {

        model.addAttribute("student", student);

        return "result";
    }
}