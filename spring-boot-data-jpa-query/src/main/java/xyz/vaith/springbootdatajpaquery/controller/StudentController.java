package xyz.vaith.springbootdatajpaquery.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.vaith.springbootdatajpaquery.bean.Clazz;
import xyz.vaith.springbootdatajpaquery.bean.Student;
import xyz.vaith.springbootdatajpaquery.service.SchoolService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private SchoolService schoolService;
    @RequestMapping("/save")
    public String save() {
        Clazz clazz1 = new Clazz();
        clazz1.setName("English");

        Clazz clazz2 = new Clazz();
        clazz2.setName("Chinese");

        List<Clazz> clazzes = new ArrayList<>();
        clazzes.add(clazz1);
        clazzes.add(clazz2);
        schoolService.saveClazzAll(clazzes);

        Student swk = new Student();
        swk.setName("孙悟空");
        swk.setAddress("花果山");
        swk.setAge(700);
        swk.setSex('男');
        swk.setClazz(clazz1);

        Student zzj = new Student();
        zzj.setName("蜘蛛精");
        zzj.setAddress("盘丝洞");
        zzj.setSex('女');
        zzj.setAge(700);
        zzj.setClazz(clazz1);

        Student nmw = new Student();
        nmw.setName("牛魔王");
        nmw.setAddress("火焰山");
        nmw.setAge(500);
        nmw.setSex('男');
        nmw.setClazz(clazz2);
        List<Student> students = new ArrayList<>();
        students.add(swk);
        students.add(zzj);
        students.add(nmw);

        schoolService.saveStudentAll(students);
        return "save success";
    }

    @RequestMapping("/getClazzStus")
    public List<Map<String, Object>> getClazzStus(String clazz) {
        return schoolService.getStusByClazzName(clazz);
    }

    @RequestMapping("/findNameAndSexByClazzName")
    public List<Map<String, Object>> findNameAndSexByClazzName(String clazzName) {
        return schoolService.findNameAndSexByClazzName(clazzName);
    }

    @RequestMapping("/findNameByClazzNameAndSex")
    public List<String> findNameByClazzNameAndSex(String clazzName, Character sex) {
        return schoolService.findNameByClazzNameAndSex(clazzName, sex);
    }

    @RequestMapping("/findClazzNameByStuName")
    public String findClazzNameByStuName(String stuName) {
        return schoolService.findClazzNameByStuName(stuName);
    }

    @RequestMapping("/deleteStuByStuName")
    public String deleteStuByStuName(String name) {
        return "delete" + schoolService.deleteStuByName(name);
    }
}
