package xyz.vaith.springbootdatabase.pojo;

import lombok.Data;
import xyz.vaith.springbootdatabase.converter.SexConverter;
import xyz.vaith.springbootdatabase.enumeration.Sex;

import javax.persistence.*;

@Data
@Entity(name = "user")
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String username;
    @Convert(converter = SexConverter.class)
    private Sex sex;
    private String note;
}
