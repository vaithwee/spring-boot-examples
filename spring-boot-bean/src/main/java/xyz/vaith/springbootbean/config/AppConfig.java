package xyz.vaith.springbootbean.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import xyz.vaith.springbootbean.domain.User;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"xyz.vaith.springbootbean.domain"}, lazyInit = true)
public class AppConfig {
    /*
    @Bean(name = "user")
    public User initUser() {
        User user = new User();
        user.setId(1l);
        user.setUserName("user_name_1");
        user.setNote("note_1");
        return user;
    }
    */

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/springboot");
        properties.setProperty("username", "root");
        properties.setProperty("password", "abcd1234");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
