package xyz.vaith.springbootdatajpaspecification.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private Integer age;
    private Character sex;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Clazz.class)
    @JoinColumn(name = "clazzId", referencedColumnName = "code")
    private Clazz clazz;


}
