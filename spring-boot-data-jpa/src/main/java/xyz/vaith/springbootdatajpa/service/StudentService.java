package xyz.vaith.springbootdatajpa.service;

import org.springframework.stereotype.Service;
import xyz.vaith.springbootdatajpa.bean.Student;
import xyz.vaith.springbootdatajpa.repository.StudentRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {
    @Resource
    private StudentRepository studentRepository;

    @Transactional
    public void saveAll(List<Student> students) {
        studentRepository.saveAll(students);
    }

    public Student getStuByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStuByNameAndAddr(String name, String address) {
        return studentRepository.findByNameAndAddress(name, address);
    }

    public List<Student> getStuByNameLike(String name) {
        return studentRepository.findByNameLike("%" + name + "%");
    }
}
