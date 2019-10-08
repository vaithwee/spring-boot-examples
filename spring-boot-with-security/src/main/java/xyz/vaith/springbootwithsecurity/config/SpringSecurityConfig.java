package xyz.vaith.springbootwithsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import xyz.vaith.springbootwithsecurity.security.MyPasswordEncoder;

@Configuration
@EnableWebSecurity

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and().logout().permitAll()
                .and().formLogin();
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //default encoder can't match password
        PasswordEncoder passwordEncoder = new MyPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("admin").password("123456").roles("ADMIN");
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("demo").password("123456").roles("USER");
    }
}
