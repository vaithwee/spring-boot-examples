package xyz.vaith.springbootdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.vaith.springbootdatajpa.bean.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByName(String name);
    List<Student> findByNameAndAddress(String name, String address);

    List<Student> findByNameLike(String name);
}
