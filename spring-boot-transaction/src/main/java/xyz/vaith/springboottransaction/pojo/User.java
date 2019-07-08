package xyz.vaith.springboottransaction.pojo;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("user")
public class User {
    private  Long id;
    private String username;
    private String note;
}
