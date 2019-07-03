package xyz.vaith.springbootdatabase.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xyz.vaith.springbootdatabase.pojo.User;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<User, Long> {
    @Query("from user where user_name like concat('%', ?1, '%') and note like concat('%', ?2, '%') ")
    List<User> findUsersByUsernameAndNote(String userName, String note);


    List<User> findByUsernameLike(String username);

    User getUserById(Long id);

    List<User> findByUsernameLikeOrNoteLike(String username, String note);
}
