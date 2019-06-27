package xyz.vaith.springbootbean.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    @Value("1")
    Long id;
    @Value("user_name_2")
    private String userName;
    @Value("note_2")
    private String note;
}
