package xyz.vaith.springbootdatajpa.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private Integer age;
    private Character sex;
}
