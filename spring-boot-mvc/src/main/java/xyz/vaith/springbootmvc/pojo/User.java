package xyz.vaith.springbootmvc.pojo;


import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("user")
public class User {
    private String username;
    private String note;
    private Long id;
    private Integer sex;
}