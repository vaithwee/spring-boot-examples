package xyz.vaith.springbootdatajpanamedquery.bean;

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
@NamedQuery(name = "Student.findStudentsByClazzName", query = "select s from Student s where s.clazz.name = ?1")
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
