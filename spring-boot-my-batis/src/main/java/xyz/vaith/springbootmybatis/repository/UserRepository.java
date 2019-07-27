package xyz.vaith.springbootmybatis.repository;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import xyz.vaith.springbootmybatis.bean.User;

import java.util.List;

@Repository
public interface UserRepository {



    @Insert("insert into tb_user (login_name, username, password) values (#{loginName}, #{username}, #{password})")
    int insertUser(User user);

    @Insert("insert into tb_user (login_name, username, password) values (#{loginName}, #{username}, #{password})")
    @Options(useGeneratedKeys = true,  keyProperty = "id", keyColumn = "id")
    void insertGenKey(User user);

    @Select("select * from tb_user where username = #{username}")
    @ResultMap("userResult")
    User selectByUsername(@Param("username") String username);

    @Select("select * from tb_user")
    @Results(id = "userResult", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "login_name", property = "loginName"),
            @Result(column = "password", property = "password"),
            @Result(column = "username", property = "username")
    })
    List<User> findAll();

    @Delete("delete from tb_user where id = #{id}")
    void delete(final Integer id);

    @Select("select * from tb_user where id = #{id}")
    @ResultMap("userResult")
    User findUserById(Integer id);

    @Update("update tb_user set login_name = #{loginName}, username = #{username} where id = #{id}")
    void update(User user);
}
