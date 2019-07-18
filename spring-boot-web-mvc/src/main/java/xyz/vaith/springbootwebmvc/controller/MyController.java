package xyz.vaith.springbootwebmvc.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import xyz.vaith.springbootwebmvc.pojo.ValidatorPojo;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/valid/page")
    public String validPage() {
        return "/validator/pojo";
    }

    @RequestMapping("/valid/validate")
    @ResponseBody
    public Map<String, Object> validate(@Valid @RequestBody ValidatorPojo pojo, Errors errors) {
        Map<String, Object> map = new HashMap<>();
        List<ObjectError> allErrors = errors.getAllErrors();
        for (ObjectError error : allErrors) {
            String key = null;
            String msg = null;
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                key = fieldError.getField();
            } else  {
                key = error.getObjectName();
            }
            msg = error.getDefaultMessage();
            map.put(key, msg);
        }
        return map;
    }

    @RequestMapping("/error")
    @ResponseBody
    public String error() {
        return 1/0 + "";
    }
}
