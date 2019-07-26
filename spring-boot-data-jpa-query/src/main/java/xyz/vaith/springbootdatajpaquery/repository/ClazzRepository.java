package xyz.vaith.springbootdatajpaquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.vaith.springbootdatajpaquery.bean.Clazz;
import xyz.vaith.springbootdatajpaquery.bean.Student;

public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
}
