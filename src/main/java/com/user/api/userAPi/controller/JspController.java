package com.user.api.userAPi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class JspController {
    @GetMapping({"/", "/banana"})
    public String hello(@RequestParam(value= "name", defaultValue = "World", required = true) String name, Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }
}
