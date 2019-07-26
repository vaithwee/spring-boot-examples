package xyz.vaith.springbootjpa.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.vaith.springbootjpa.bean.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
