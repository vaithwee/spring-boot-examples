package xyz.vaith.springbootjdbc.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import xyz.vaith.springbootjdbc.bean.User;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class UserRepository {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public int insertUser() {
        String sql = "insert into tb_user (login_name, username, password) values (?,?,?), (?,?,?), (?,?,?)";
        Object[] args = new Object[]{"swk", "孙悟空", "123456", "zbj", "猪八戒", "123456", "ts", "唐僧", "123456"};
        return jdbcTemplate.update(sql, args);
    }

    public User selectByUsername(String username) {
        String sql = "select * from tb_user where username = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
         User user = jdbcTemplate.queryForObject(sql, new Object[]{username}, rowMapper);
         return user;
    }

    public User findUserById(Integer id) {
        String sql = "select * from tb_user where id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
         return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    public List<User> findAll() {
        String sql = "select * from tb_user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void delete(final Integer user_id) {
        String sql = "delete from tb_user where id = ?";
        jdbcTemplate.update(sql, new Object[]{user_id});
    }

    public void update(final User user) {
        String sql = "update tb_user set username = ?, login_name = ? where id = ?";
        jdbcTemplate.update(sql, new Object[]{user.getUsername(), user.getLoginName(), user.getId()});
    }


    public User insertGenKey(User user) {
        String sql = "insert into tb_user (username, login_name, password) values (?,?,?)";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getLoginName());
                ps.setString(3, user.getPassword());
                return ps;
            }
        }, holder);
        Integer newUserId = holder.getKey().intValue();
        user.setId(newUserId);
        return user;

    }
}
