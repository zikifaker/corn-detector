package com.example.corndetector.service;

import com.example.corndetector.entity.User;
import com.example.corndetector.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public User getUserInfo(int id){
        return userMapper.selectById(id);
    }
}
