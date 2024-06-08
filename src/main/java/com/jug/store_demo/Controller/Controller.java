package com.jug.store_demo.Controller;

import com.jug.store_demo.Model.User;
import com.jug.store_demo.Model.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user") // http:localhost:8080/api/user
public class Controller {
    private final UserService userService;

    // Constructor
    public Controller(UserService userService) {
        this.userService = userService;
    }
    //GET
    @GetMapping("getAll")
    public List<User> getMethodName() {
        return userService.getUsers();
    }

    // POST
    @PostMapping("addUser")
    public void addUser(@Validated @RequestBody User user) {
        userService.addUser(user);
    }

    // DELETE
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

}
