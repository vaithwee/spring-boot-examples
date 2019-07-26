package xyz.vaith.springbootdatajpanamedquery.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.vaith.springbootdatajpanamedquery.service.SchoolService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private SchoolService schoolService;

    @RequestMapping("/getClazzStus")
    public List<Map<String, Object>> getClazzStus(String clazzName) {
        return schoolService.getStusByClazzName(clazzName);
    }
}
