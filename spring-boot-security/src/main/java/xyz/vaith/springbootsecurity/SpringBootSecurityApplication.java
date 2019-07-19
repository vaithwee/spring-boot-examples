package xyz.vaith.springbootsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringBootSecurityApplication extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityApplication.class, args);
    }

    @Autowired
    private DataSource dataSource;
    String pwdQuery = "select user_name, pwd, available from t_user where user_name = ?";
    String roleQuery = "select u.user_name, r.role_name from t_user u, t_user_role ur, t_role r where u.id = ur.user_id and r.id = ur.role_id and u.user_name = ?";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("admin").password(passwordEncoder.encode("abcd1234")).roles("USER", "ADMIN").and().withUser("myuser").password(passwordEncoder.encode("123456")).roles("USER");

         */

        PasswordEncoder passwordEncoder =  new Pbkdf2PasswordEncoder(secert);
        auth.jdbcAuthentication().passwordEncoder(passwordEncoder).dataSource(dataSource).usersByUsernameQuery(pwdQuery).authoritiesByUsernameQuery(roleQuery);
    }

    @Value("${system.user.password.secret}")
    private String secert;
}
