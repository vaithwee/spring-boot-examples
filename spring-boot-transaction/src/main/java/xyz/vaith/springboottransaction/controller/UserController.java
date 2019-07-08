package xyz.vaith.springboottransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.vaith.springboottransaction.pojo.User;
import xyz.vaith.springboottransaction.service.UserBatchService;
import xyz.vaith.springboottransaction.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserBatchService userBatchService;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @RequestMapping("/insertUser")
     @ResponseBody
    public Map<String, Object> insertUser(String username, String note) {
        User user = new User();
        user.setUsername(username);
        user.setNote(note);
        int update = userService.insertUser(user);
        Map<String, Object> result = new HashMap<>();
        result.put("success", update == 1);
        result.put("user", user);
        return result;
    }

    @RequestMapping("/insertUsers")
    @ResponseBody
    public Map<String, Object> insertUsers(String username1, String note1, String username2, String note2) {
        User user1 = new User();
        user1.setUsername(username1);
        user1.setNote(note1);

        User user2 = new User();
        user2.setUsername(username2);
        user2.setNote(note2);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        int count = userBatchService.insertUsers(users);
        Map<String, Object> result = new HashMap<>();
        result.put("success", count > 0);
        result.put("users", users);
        return result;
    }
}
