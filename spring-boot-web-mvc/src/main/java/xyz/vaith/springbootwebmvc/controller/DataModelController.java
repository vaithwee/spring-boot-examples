package xyz.vaith.springbootwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.vaith.springbootwebmvc.pojo.User;

@RequestMapping("/data")
@Controller
public class DataModelController {

    @GetMapping("/model")
    public String userModel(Long id, Model model) {
        User user = new User();
        user.setId(id);
        user.setUsername("wee");
        user.setNote("note1");
        model.addAttribute("user", user);
        return "data/user";
    }

    @GetMapping("/modelMap")
    public ModelAndView useModelMap(Long id, ModelMap modelMap) {
        User user = new User();
        user.setId(id);
        user.setUsername("wee");
        user.setNote("note1");

        modelMap.put("user", user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("data/user");
        return modelAndView;
    }
}
