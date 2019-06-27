package xyz.vaith.springbootproperties.controller;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.vaith.springbootproperties.domain.DataBaseProperties;
import xyz.vaith.springbootproperties.domain.JdbcProperties;
import xyz.vaith.springbootproperties.domain.OtherDataBaseProperties;

@RestController
public class IndexController {
    @Autowired @Setter
    DataBaseProperties properties;

    @Autowired @Setter
    OtherDataBaseProperties baseProperties;

    @Autowired @Setter
    JdbcProperties jdbcProperties;

    @RequestMapping("/")
    public String index() {
        return properties.toString();
    }

    @RequestMapping("/other")
    public String other() {
        return baseProperties.toString();
    }

    @RequestMapping("/jdbc")
    public String jdbc() {
        return jdbcProperties.toString();
    }
}
