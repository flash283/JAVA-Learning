package com.bookmanger.springbootbookmanager.service;

import com.bookmanger.springbootbookmanager.User;
import com.bookmanger.springbootbookmanager.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public String register(User user){
        if(userMapper.findByUsername(user.getUsername())!=null){
            return "用户名已存在";
        }
        userMapper.register(user);
        return "注册成功";
    }

    public String login(User user) {
        User dbUser = userMapper.findByUsername(user.getUsername());
        if (dbUser == null) {
            return "用户不存在";
        }
        if (!dbUser.getPassword().equals(user.getPassword())) {
            return "密码错误";
        }
        return "登录成功";
    }

    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    public User queryById(int id) {
        return userMapper.queryById(id);
    }

    public boolean updateUser(int id, User user) {
        user.setId(id);
        return userMapper.updateUser(user) > 0;
    }

    public boolean deleteUser(int id) {
        return userMapper.deleteUser(id) > 0;
    }
}
