package com.example.simplespringboottest.service;

import com.example.simplespringboottest.entity.User;
import com.example.simplespringboottest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Boolean save(User user1) {
        userMapper.save(user1);
        if (userMapper.existsById(user1.getId())){

            return true;
        }
        return false;
    }


}
