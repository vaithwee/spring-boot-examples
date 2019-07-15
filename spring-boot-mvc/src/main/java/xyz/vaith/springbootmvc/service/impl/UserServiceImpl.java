package xyz.vaith.springbootmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vaith.springbootmvc.dao.UserDao;
import xyz.vaith.springbootmvc.pojo.User;
import xyz.vaith.springbootmvc.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> findUsers(String username, String note) {
        return userDao.findUsers(username, note);
    }
}
