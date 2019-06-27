package xyz.vaith.springbootproperties.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("database")
@Data
public class OtherDataBaseProperties {
    private String driverName;
    private String url;
    private String username;
    private String password;
}
