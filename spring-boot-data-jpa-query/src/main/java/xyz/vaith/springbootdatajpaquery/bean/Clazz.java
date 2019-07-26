package xyz.vaith.springbootdatajpaquery.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_clazz")
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Student.class, mappedBy = "clazz")
    private Set<Student> students = new HashSet<>();

}
