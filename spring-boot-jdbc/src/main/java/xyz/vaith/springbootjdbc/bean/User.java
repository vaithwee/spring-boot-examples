package xyz.vaith.springbootjdbc.bean;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String loginName;
    private String username;
    private String password;
}
