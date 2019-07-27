package xyz.vaith.springboottest.service;

import org.springframework.stereotype.Service;
import xyz.vaith.springboottest.bean.Student;
import xyz.vaith.springboottest.repository.StudentRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SchoolService {
    @Resource
    private StudentRepository studentRepository;

    @Transactional
    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student selectByKey(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.get();
    }
}
