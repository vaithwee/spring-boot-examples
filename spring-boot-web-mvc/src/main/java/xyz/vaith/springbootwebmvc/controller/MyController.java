package xyz.vaith.springbootwebmvc.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("/requestArray")
    @ResponseBody
    public Map<String, Object> requestArray(Integer[] intArr, Long[] longArr, String[] strArr) {
        Map<String, Object> map = new HashMap<>();
        map.put("intArr", intArr);
        map.put("longArr", longArr);
        map.put("strArr", strArr);
        return map;
    }

    @GetMapping("/format/form")
    public String showFormat() {
        return "format/formatter";
    }

    @PostMapping("/format/commit")
     @ResponseBody
    public Map<String, Object> format(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date date, @NumberFormat(pattern = "#,###.##") Double number) {
        Map<String, Object> map = new HashMap<>();
        map.put("date", date);
        map.put("number", number);
        return map;
    }
}
