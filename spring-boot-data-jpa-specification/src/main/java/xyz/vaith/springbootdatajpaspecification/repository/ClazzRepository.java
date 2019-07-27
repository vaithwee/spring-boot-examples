package xyz.vaith.springbootdatajpaspecification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xyz.vaith.springbootdatajpaspecification.bean.Clazz;

public interface ClazzRepository extends JpaRepository<Clazz, Integer>, JpaSpecificationExecutor<Clazz> {
}
