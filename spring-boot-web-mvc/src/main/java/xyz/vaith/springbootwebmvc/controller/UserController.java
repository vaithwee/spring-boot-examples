package xyz.vaith.springbootwebmvc.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import xyz.vaith.springbootwebmvc.pojo.User;
import xyz.vaith.springbootwebmvc.validator.UserValidator;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping("/add")
    public String add() {
        return "user/add";
    }

    @PostMapping("/insert")
    @ResponseBody
    public User insert(@RequestBody User user) {
        return user;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User get(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @GetMapping("/converter")
    @ResponseBody
    public User getUserByConverter(User user) {
        return user;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<User> list(@RequestParam(value = "users") List<User> users) {
        return users;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    @GetMapping("/validator")
    @ResponseBody
    public Map<String, Object> validator(@Valid User user, Errors errors, Date date) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("date", date);
        if (errors.hasErrors()) {
            List<ObjectError> errorList = errors.getAllErrors();
            for (ObjectError error : errorList) {
                if (error instanceof FieldError) {
                    FieldError fe = (FieldError) error;
                    map.put(fe.getField(), fe.getDefaultMessage());
                } else  {
                    map.put(error.getObjectName(), error.getDefaultMessage());
                }
            }
        }
        return map;
    }
}
