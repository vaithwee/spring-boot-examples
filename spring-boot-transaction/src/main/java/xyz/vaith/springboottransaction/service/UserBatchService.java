package xyz.vaith.springboottransaction.service;

import xyz.vaith.springboottransaction.pojo.User;

import java.util.List;

public interface UserBatchService {
    int insertUsers(List<User> users);
}
