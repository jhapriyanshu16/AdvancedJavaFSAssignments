package org.example.restapicrud.controller;

import org.example.restapicrud.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    private Map<Integer,User> userDb = new HashMap<>();

    @GetMapping
    public ResponseEntity<String> testAPI(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("The API is working correctly");
    }

    @GetMapping("/users")
    public User getUsers(){
        return new User(1,"Priyanshu",22);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        userDb.put(user.getId(),user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        return userDb.get(id);
    }

    @PutMapping("/users")
    public String updateUser(@RequestBody User user){
        int id = user.getId();
        System.out.println("Incoming ID: " + id);
        if (userDb.containsKey(id)){
            userDb.put(id,user);
            return "User successfully updated";
        }
        else{
            return "No user with the key found";
        }
    }

    @GetMapping("/users/fetch/{id}")
    public ResponseEntity<String> fetchUser(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("User created with id "+id);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        if(userDb.containsKey(id)){
            userDb.remove(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("User deleted with id "+id);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user with the key found");
        }
    }

    @GetMapping("search")
    public String searchUser(@RequestParam String name){

    }








}
