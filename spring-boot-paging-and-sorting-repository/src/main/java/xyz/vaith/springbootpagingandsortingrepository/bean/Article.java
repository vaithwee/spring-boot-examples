package xyz.vaith.springbootpagingandsortingrepository.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_article")
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String supplier;
    private Double price;
    private String locality;
    private Date putawayDate;
    private Integer storage;
    private String image;
    private String description;
    private Date createDate;
}
