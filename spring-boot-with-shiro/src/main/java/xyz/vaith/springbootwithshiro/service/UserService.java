package xyz.vaith.springbootwithshiro.service;

import xyz.vaith.springbootwithshiro.model.User;

public interface UserService {
    User findUserByUsername(String username);
}
