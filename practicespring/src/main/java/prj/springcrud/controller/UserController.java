package prj.springcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import prj.springcrud.service.UserService;

import java.util.*;


@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(String name){
        userService.addUser(name);
        System.out.println("User added "+name);
    }

    public void listUsers(){
        List<String> users = userService.getAllUsers();
        System.out.println("All users : " + users);
    }
}
