package xyz.vaith.springbootmongoresposity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.vaith.springbootmongoresposity.model.Coffee;

import java.util.List;

public interface CoffeeRepository extends MongoRepository<Coffee, String> {
    List<Coffee> findByName(String name);
}
