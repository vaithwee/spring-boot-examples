package xyz.vaith.springbootwithshiro.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.vaith.springbootwithshiro.model.User;

public interface UserMapper {
    User findUserByUsername(@Param("username") String username);
}
