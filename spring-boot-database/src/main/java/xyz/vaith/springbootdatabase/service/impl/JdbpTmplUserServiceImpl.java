package xyz.vaith.springbootdatabase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import xyz.vaith.springbootdatabase.enumeration.Sex;
import xyz.vaith.springbootdatabase.pojo.User;
import xyz.vaith.springbootdatabase.service.JdbpTmplUserService;
import java.sql.ResultSet;

import java.util.List;

@Service
public class JdbpTmplUserServiceImpl implements JdbpTmplUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> getUserMapper() {
        RowMapper<User> userRowMapper = (ResultSet rs, int rownum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("user_name"));
            int sexId = rs.getInt("sex");
            Sex sex = Sex.getEnumById(sexId);
            user.setSex(sex);
            user.setNote(rs.getString("note"));
            return user;
        };
        return userRowMapper;
    }

    @Override
    public User getById(Long id) {
        String sql = "select id, user_name, sex, note from t_user where id = ?";
        Object[] params = new Object[] {id};
        User user = jdbcTemplate.queryForObject(sql, params, getUserMapper());
        return user;
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        String sql = "select * from t_user where username like concat('%', ?, '%') and note like concat('%', ?, '%')";
        Object[] params = new Object[] {userName, note};
        List<User> users = jdbcTemplate.query(sql, params, getUserMapper());
        return users;
    }

    @Override
    public int insert(User user) {
       String sql = "insert into t_user (user_name, sex, note) values(?, ?, ?)";
       return jdbcTemplate.update(sql, user.getUsername(), user.getSex().getId(), user.getNote());
    }



    @Override
    public int update(User user) {
        String sql = "update t_user set user_name = ?, sex = ?, note = ? where id = ?";
        return jdbcTemplate.update(sql, user.getUsername(), user.getSex().getId(), user.getNote(), user.getId());
    }

    @Override
    public int delete(Long id) {
        String sql = "delete from t_user where id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
