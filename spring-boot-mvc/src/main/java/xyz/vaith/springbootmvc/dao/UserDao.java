package xyz.vaith.springbootmvc.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xyz.vaith.springbootmvc.pojo.User;

import java.util.List;

@Repository
public interface UserDao {
    User getUser(Long id);
    List<User> findUsers(@Param("username") String username, @Param("note") String note);
}
