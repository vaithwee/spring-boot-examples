package xyz.vaith.springbootdatabase.pojo;

import lombok.Data;
import xyz.vaith.springbootdatabase.enumeration.Sex;

@Data
public class User {
    private Long id;
    private String username;
    private Sex sex;
    private String note;
}
