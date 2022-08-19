package com.example.springwebscope.controller;

import com.example.springwebscope.service.NumberService;
import com.example.springwebscope.service.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private NumberService numberService; // proxy

    @GetMapping("/home")
    public String indexAction(Model model) {
        model.addAttribute("message", numberService.getValue());
        return "index.html";
    }
}
