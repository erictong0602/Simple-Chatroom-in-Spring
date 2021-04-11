package com.user.api.userAPi.controller;


import com.user.api.userAPi.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.user.api.userAPi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @GetMapping(path = "/addUser")
//    public String user(@RequestParam(value= "name", defaultValue = "Default User", required = true) String name, Model model){
//        model.addAttribute("name",name);
//        return "createuser";
//    }

    @PostMapping(path="/register")
    public Status addUser(@Valid @RequestBody User newUser){

        List<User> users = userRepository.findAll();

        System.out.println("New user "+ newUser.toString());

        for (User user: users){
            System.out.println("Registered user: " + newUser.toString());

            if(user.equals(newUser)){
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXIST;
            }
        }

        userRepository.save(newUser);
        return Status.SUCCESS;
    }

    @PostMapping(path="/login")
    public Status Login(@Valid @RequestBody User user){

        List<User> users = userRepository.findAll();

        for(User other: users) {
            if(other.equals(user)){
                user.setLoggedIn(true);
                Date date = new Date();
                userRepository.userStatus(user.getLoggedIn(), user.getUsername(),date, user.getUsername());
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    @PostMapping(path = "/logout")
    public Status Logout(@Valid @RequestBody User user){

        List <User> users = userRepository.findAll();

        for(User other: users) {
            if(other.equals(user)){
                user.setLoggedIn(false);
                Date date = new Date();
                userRepository.userStatus(user.getLoggedIn(), user.getUsername(),date, user.getUsername());
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    @DeleteMapping(path = "/clearAll")
    public Status Clear(){
        userRepository.deleteAll();
        return Status.SUCCESS;
    }

}
