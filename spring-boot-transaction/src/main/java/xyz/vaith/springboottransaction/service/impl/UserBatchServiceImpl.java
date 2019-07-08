package xyz.vaith.springboottransaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vaith.springboottransaction.pojo.User;
import xyz.vaith.springboottransaction.service.UserBatchService;
import xyz.vaith.springboottransaction.service.UserService;

import java.util.List;

@Service
public class UserBatchServiceImpl implements UserBatchService {

    @Autowired
    private UserService service;

    @Override
    public int insertUsers(List<User> users) {
        int count = 0;
        for (User user : users) {
            count += service.insertUser(user);
        }
        return count;
    }
}
