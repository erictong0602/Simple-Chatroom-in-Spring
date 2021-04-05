package com.user.api.userAPi.controller;

import com.user.api.userAPi.model.Room;
import com.user.api.userAPi.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/room")
public class RoomController {

//    @Value("${welcome.message:test}")
//    private String message = "Hello World";

    @Autowired
    RoomRepository roomRepository;

    @GetMapping(path="/createRoom")
    public String room(@RequestParam(value= "name", defaultValue = "Default User", required = true) String name, Model model){
        model.addAttribute("name",name);
        return "createroom";
    }

    @PostMapping(path="/createRoom")
    public @ResponseBody String addRoom(@RequestBody Room room){
        roomRepository.save(room);
        return "saved";
    }
}
