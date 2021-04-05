package com.user.api.userAPi.controller;

import com.user.api.userAPi.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.user.api.userAPi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/addUser")
    public String user(@RequestParam(value= "name", defaultValue = "Default User", required = true) String name, Model model){
        model.addAttribute("name",name);
        return "createuser";
    }

    @PostMapping(path="/addUser")
    public @ResponseBody String addUser(@RequestBody User user_Name){
        userRepository.save(user_Name);
        return "saved";
    }

//    @GetMapping(path="/")
//    public @ResponseBody String sayHello(){
//        return "Welcome to pages";
//    }
}
