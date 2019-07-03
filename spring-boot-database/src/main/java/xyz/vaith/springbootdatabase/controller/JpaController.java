package xyz.vaith.springbootdatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.vaith.springbootdatabase.dao.JpaUserRepository;
import xyz.vaith.springbootdatabase.pojo.User;

import java.util.List;

@Controller
@RequestMapping("/jpa")
public class JpaController {
    @Autowired
    private JpaUserRepository jpaUserRepository;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id) {
         User user = jpaUserRepository.findById(id).get();
         return user;
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserById(Long id) {
        User user = jpaUserRepository.getUserById(id);
        return user;
    }

    @RequestMapping("/findByUserNameLike")
    @ResponseBody
    public List<User> findByUsernameLike(String username) {
        List<User> users = jpaUserRepository.findByUsernameLike(username);
        return users;
    }

    @RequestMapping("/findByUsernameLikeOrNoteLike")
    @ResponseBody
    public List<User> findByUsernameLikeOrNoteLike(String username, String note) {
        List<User> users = jpaUserRepository.findByUsernameLikeOrNoteLike(username, note);
        return users;
    }

}
