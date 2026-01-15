package com.example.springapipalmaven.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springapipalmaven.service.OlaMundoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final OlaMundoService service;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", this.service.findAll());
        return "home";
    }
    
}
