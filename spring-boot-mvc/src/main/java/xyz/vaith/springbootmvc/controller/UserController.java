package xyz.vaith.springbootmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import xyz.vaith.springbootmvc.pojo.User;
import xyz.vaith.springbootmvc.service.UserService;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/details")
//    @ResponseBody
    public ModelAndView details(Long id) {
        User user = userService.getUser(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/details");
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/detailForJson")
    public ModelAndView detailForJson(Long id) {
        User user = userService.getUser(id);
        ModelAndView mv = new ModelAndView();
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        mv.setView(jsonView);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/table")
    @ResponseBody
    public List<User> table() {
        List<User> users = userService.findUsers(null, null);
        return users;
    }
}
