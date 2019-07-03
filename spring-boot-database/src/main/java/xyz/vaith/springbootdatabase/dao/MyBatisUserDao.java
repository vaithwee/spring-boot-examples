package xyz.vaith.springbootdatabase.dao;

import org.springframework.stereotype.Repository;
import xyz.vaith.springbootdatabase.pojo.User;

@Repository
public interface MyBatisUserDao {
    User getUser(Long id);
}
