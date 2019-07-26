package xyz.vaith.springbootdatajpaquery.service;

import org.springframework.stereotype.Service;
import xyz.vaith.springbootdatajpaquery.bean.Clazz;
import xyz.vaith.springbootdatajpaquery.bean.Student;
import xyz.vaith.springbootdatajpaquery.repository.ClazzRepository;
import xyz.vaith.springbootdatajpaquery.repository.StudentRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SchoolService {
    @Resource
    private StudentRepository studentRepository;

    @Resource
    private ClazzRepository clazzRepository;

    @Transactional
    public void saveClazzAll(List<Clazz> clazzes) {
        clazzRepository.saveAll(clazzes);
    }

    @Transactional
    public void saveStudentAll(List<Student> students) {
        studentRepository.saveAll(students);
    }


    public List<Map<String, Object>> getStusByClazzName(String clazzName) {
        List<Student> students = studentRepository.findByClazz_Name(clazzName);
        List<Map<String, Object>> results = new ArrayList<>();
        for (Student student : students) {
            Map<String, Object> stu = new HashMap<>();
            stu.put("name", student.getName());
            stu.put("age", student.getAge());
            stu.put("sex", student.getSex());
            results.add(stu);
        }
        return results;
    }

    public List<Map<String, Object>> findNameAndSexByClazzName(String clazzName) {
        return studentRepository.findNameAndSexByClazzName(clazzName);
    }

    public List<String> findNameByClazzNameAndSex(String clazzName, char sex) {
        return studentRepository.findNameByClazzNameAndSex(clazzName, sex);
    }

    public String findClazzNameByStuName(String stuName) {
        return studentRepository.findClazzNameByStuName(stuName);
    }

    @Transactional
    public int deleteStuByName(String stuName) {
        return studentRepository.deleteStuByStuName(stuName);
    }
}
