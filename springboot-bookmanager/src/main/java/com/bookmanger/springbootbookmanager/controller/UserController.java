package com.bookmanger.springbootbookmanager.controller;


import com.bookmanger.springbootbookmanager.Result;
import com.bookmanger.springbootbookmanager.User;
import com.bookmanger.springbootbookmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result<String> register(@RequestBody User user){
        return Result.success(userService.register(user));
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody User user) {
        return Result.success(userService.login(user));
    }

}
