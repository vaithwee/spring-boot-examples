package xyz.vaith.springboottransaction.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.vaith.springboottransaction.pojo.User;

@Repository
public interface UserDao {
    User getUser(Long id);
    int insertUser(User user);
}
