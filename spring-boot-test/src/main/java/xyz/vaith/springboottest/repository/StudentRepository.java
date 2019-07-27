package xyz.vaith.springboottest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.vaith.springboottest.bean.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
