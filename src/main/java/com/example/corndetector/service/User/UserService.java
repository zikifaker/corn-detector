package com.example.corndetector.service.User;

import com.example.corndetector.dao.UserDao;
import com.example.corndetector.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(int id){
        Optional<User> userOptional = userDao.findById(id);
        return userOptional.orElse(null);
    }
}
