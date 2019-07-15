package xyz.vaith.springbootwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/my")
@Controller
public class MyController {
    @GetMapping("/no/annotation")
    @ResponseBody
    public Map<String, Object> noAnnotation(Integer intVal, Long longVal, String str) {
        Map<String, Object> map = new HashMap<>();
        map.put("intVal", intVal);
        map.put("longVal", longVal);
        map.put("str", str);
        return map;
    }

    @GetMapping("/annotation")
    @ResponseBody
    public Map<String, Object> requestParam(@RequestParam("int_val") Integer intVal, @RequestParam("long_val") Long longVal, @RequestParam(value = "str_val", required = false) String strVal) {
        Map<String, Object> map = new HashMap<>();
        map.put("intVal", intVal);
        map.put("longVal", longVal);
        map.put("strVal", strVal);
        return map;
    }
}
