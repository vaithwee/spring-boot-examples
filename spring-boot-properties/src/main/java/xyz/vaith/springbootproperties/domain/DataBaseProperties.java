package xyz.vaith.springbootproperties.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class DataBaseProperties {
    @Value("${database.driverName}")
    private String driverName = null;

    @Value("${database.url}")
    private String url = null;

    private String username;
    private String password;

    @Value("${database.username}")
    public void setUsername(String username) {
        this.username = username;
    }

    @Value("${database.password}")
    public void setPassword(String password) {
        this.password = password;
    }
}
