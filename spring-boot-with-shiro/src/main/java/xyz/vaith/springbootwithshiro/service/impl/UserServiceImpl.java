package xyz.vaith.springbootwithshiro.service.impl;

import org.springframework.stereotype.Service;
import xyz.vaith.springbootwithshiro.mapper.UserMapper;
import xyz.vaith.springbootwithshiro.model.User;
import xyz.vaith.springbootwithshiro.service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }
}
