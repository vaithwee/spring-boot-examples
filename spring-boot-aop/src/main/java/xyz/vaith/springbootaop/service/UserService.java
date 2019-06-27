package xyz.vaith.springbootaop.service;

import xyz.vaith.springbootaop.dao.UserDao;
import xyz.vaith.springbootaop.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserService {
    public int insertUser() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("user_name_1");
        user.setNote("note_1");
        Connection connection = null;
        int result = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://10.1.4.119:3306/springboot", "root", "abcd1234");
            connection.setAutoCommit(false);
            result = userDao.insertUser(connection, user);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
