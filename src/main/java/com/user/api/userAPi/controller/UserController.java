package com.user.api.userAPi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.user.api.userAPi.repository.UserRepository;
import com.user.api.userAPi.model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path="/user-api")
public class UserController {
    // inject via application.properties

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/message")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }

    @GetMapping(path="/")
    public @ResponseBody String sayHello(){
        return "Welcome to pages";
    }

    @PostMapping(path="/addUser")
    public @ResponseBody String addUser(@RequestBody UserForm user){
        userRepository.save(user);
        return "saved";
    }
}
