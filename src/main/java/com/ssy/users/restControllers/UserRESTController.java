package com.ssy.users.restControllers;

import com.ssy.users.entities.User;
import com.ssy.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserRESTController {

    @Autowired
    UserService userService;

    //@RequestMapping(path = "all", method = RequestMethod.GET)
    @GetMapping("all")
    public List<User> getAllUsers(){

        return userService.findAllUsers();
    }
}
