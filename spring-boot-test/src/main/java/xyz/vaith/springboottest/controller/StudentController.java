package xyz.vaith.springboottest.controller;

import org.springframework.web.bind.annotation.*;
import xyz.vaith.springboottest.bean.Student;
import xyz.vaith.springboottest.service.SchoolService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private SchoolService schoolService;

    @PostMapping("/save")
    public Map<String, Object> save(@RequestBody Student student) {
        schoolService.save(student);
        Map<String, Object> params = new HashMap<>();
        params.put("code", "success");
        return params;
    }

    @GetMapping("/get/{id}")
    public Student qryStu(@PathVariable("id") Integer id) {
        Student student = schoolService.selectByKey(id);
        return student;
    }
}
