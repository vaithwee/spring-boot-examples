package xyz.vaith.springbootmvc.service;

import xyz.vaith.springbootmvc.pojo.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    List<User> findUsers(String username, String note);
}
