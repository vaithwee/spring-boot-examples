package xyz.vaith.springbootjson.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private String author;
    private String image;
    private Double price;
    private String remark;
}
