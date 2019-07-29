package xyz.vaith.springbootsecurityjpa.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String loginName;
    private String username;
    private String password;

    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_role", joinColumns = {@JoinColumn(name = "user_id"), }, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;


}
