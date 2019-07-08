package xyz.vaith.springboottransaction.service;

import xyz.vaith.springboottransaction.pojo.User;


public interface UserService {
    int insertUser(User user);
    User getUser(Long id);
}
