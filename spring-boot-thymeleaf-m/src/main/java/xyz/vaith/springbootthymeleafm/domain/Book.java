package xyz.vaith.springbootthymeleafm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Book implements Serializable {
    private Integer id;
    private String title;
    private String image;
    private String author;
    private Double price;
}
