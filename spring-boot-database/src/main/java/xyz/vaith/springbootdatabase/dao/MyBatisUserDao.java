package xyz.vaith.springbootdatabase.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.vaith.springbootdatabase.pojo.User;

@Mapper
public interface MyBatisUserDao {
    User getUser(Long id);
}
