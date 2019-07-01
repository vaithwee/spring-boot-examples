package xyz.vaith.springbootdatabase.service;

import xyz.vaith.springbootdatabase.pojo.User;

import java.util.List;

public interface JdbpTmplUserService {
    User getById(Long id);
    List<User> findUsers(String userName, String note);
    int insert(User user);
    int update(User user);
    int delete(Long id);
}
