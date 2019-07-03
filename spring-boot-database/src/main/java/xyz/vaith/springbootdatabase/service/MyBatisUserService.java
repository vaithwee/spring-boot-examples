package xyz.vaith.springbootdatabase.service;

import xyz.vaith.springbootdatabase.pojo.User;

public interface MyBatisUserService {
    User getUser(Long id);
}
