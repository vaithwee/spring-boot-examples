package xyz.vaith.springbootdatajpaquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.vaith.springbootdatajpaquery.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByClazz_Name(String clazzName);

    @Query("select s from  Student s where s.clazz.name = ?1")
    List<Student> findStudentByClazzName(String clazzName);

    @Query("select new Map(s.name as name, s.sex as sex) from Student  s where s.clazz.name = ?1")
    List<Map<String, Object>> findNameAndSexByClazzName(String clazzName);

    @Query("select s.name from Student s where s.clazz.name = :clazzName and s.sex = :sex")
    List<String> findNameByClazzNameAndSex(@Param("clazzName") String clazzName, @Param("sex") char sex);

    @Query("select c.name from Clazz c inner join c.students s where s.name = ?1")
    String findClazzNameByStuName(String stuName);

    @Modifying
    @Query("delete from Student s where s.name = ?1")
    int deleteStuByStuName(String stuName);
}
