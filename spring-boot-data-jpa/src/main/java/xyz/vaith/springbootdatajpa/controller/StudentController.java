package xyz.vaith.springbootdatajpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.vaith.springbootdatajpa.bean.Student;
import xyz.vaith.springbootdatajpa.service.StudentService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService service;

    @RequestMapping("/save")
    public String save() {
        Student swk = new Student();
        swk.setAddress("广州");
        swk.setName("孙悟空");
        swk.setAge(700);
        swk.setSex('男');

        Student zzj = new Student();
        zzj.setAddress("广州");
        zzj.setName("蜘蛛精");
        zzj.setAge(700);
        zzj.setSex('女');

        Student nmw = new Student();
        nmw.setAddress("火焰山");
        nmw.setName("牛魔王");
        nmw.setAge(500);
        nmw.setSex('男');

        List<Student> students = new ArrayList<>();
        students.add(swk);
        students.add(zzj);
        students.add(nmw);
        service.saveAll(students);
        return "save success";
    }

    @RequestMapping("/name")
    public Student getByName(@RequestParam("name") String name) {
        return service.getStuByName(name);
    }

    @RequestMapping("/nameAndAddress")
    public List<Student> getByNameAndAddress(String name, String address) {
        return service.getStuByNameAndAddr(name, address);
    }

    @RequestMapping("/nameLike")
    public List<Student> getByNameLike(@RequestParam("name") String name) {
        return service.getStuByNameLike(name);
    }
}
