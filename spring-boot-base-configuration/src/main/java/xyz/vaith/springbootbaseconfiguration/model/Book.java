package xyz.vaith.springbootbaseconfiguration.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "book")
@Data
public class Book {
    private String name;
    private String author;
    private Double price;
}
