package xyz.vaith.springbooterror.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeptController {
    @RequestMapping("/add")
    public String add(String deptname) throws Exception {
        if (deptname == null) {
            throw new NullPointerException("dept name can't be null");
        }
        return "success";
    }
}
