package com.bookmanger.springbootbookmanager.controller;


import com.bookmanger.springbootbookmanager.Result;
import com.bookmanger.springbootbookmanager.User;
import com.bookmanger.springbootbookmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public Result<List<User>> queryAll() {
        return Result.success(userService.queryAll());
    }

    @GetMapping("/{id}")
    public Result<User> queryById(@PathVariable int id) {
        return Result.success(userService.queryById(id));
    }

    @PutMapping("/{id}")
    public Result<String> updateUser(@PathVariable int id, @RequestBody User user) {
        if (userService.updateUser(id, user)) {
            return Result.success("修改成功");
        }
        return Result.error("修改失败");
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteUser(@PathVariable int id) {
        if (userService.deleteUser(id)) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }



}
