package xyz.vaith.springbootdatajpanamedquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.vaith.springbootdatajpanamedquery.bean.Clazz;

public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
}
