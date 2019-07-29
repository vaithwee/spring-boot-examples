package xyz.vaith.springbootsecurityjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vaith.springbootsecurityjpa.pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginName(String loginName);

}
