package xyz.vaith.springbootdatabase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vaith.springbootdatabase.dao.MyBatisUserDao;
import xyz.vaith.springbootdatabase.pojo.User;
import xyz.vaith.springbootdatabase.service.MyBatisUserService;

@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {
    @Autowired
    private MyBatisUserDao myBatisUserDao;
    @Override
    public User getUser(Long id) {
        return myBatisUserDao.getUser(id);
    }
}
