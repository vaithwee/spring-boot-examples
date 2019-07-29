package xyz.vaith.springbootsecuritytest.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Log4j2
public class AppSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppAuthenticationSuccessHandler appAuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       log.info("AppSecurityConfigurer configure() execute");
       http.authorizeRequests()
               .antMatchers("/login", "/css/**", "/js/**", "/img/*").permitAll()
               .antMatchers("/", "/home").hasRole("USER")
               .antMatchers("/admin/**").hasAnyRole("ADMIN", "DBA")
               .anyRequest().authenticated()
               .and()
               .formLogin().loginPage("/login")
               .successHandler(appAuthenticationSuccessHandler)
               .usernameParameter("username").passwordParameter("password")
               .and()
               .logout().permitAll()
               .and()
               .exceptionHandling().accessDeniedPage("/accessDenied");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("AppSecurityConfiguere configure(auth) executed");
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("wee").password("123456").roles("USER");
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("admin").password("admin").roles("ADMIN", "DBA");
    }
}
