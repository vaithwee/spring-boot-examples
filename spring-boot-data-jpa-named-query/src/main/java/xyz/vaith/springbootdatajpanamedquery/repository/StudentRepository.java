package xyz.vaith.springbootdatajpanamedquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.vaith.springbootdatajpanamedquery.bean.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student , Integer> {
    List<Student> findStudentsByClazzName(String clazzName);
}


