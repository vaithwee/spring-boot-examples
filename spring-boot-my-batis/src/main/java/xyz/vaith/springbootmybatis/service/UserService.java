package xyz.vaith.springbootmybatis.service;

import org.springframework.stereotype.Service;
import xyz.vaith.springbootmybatis.bean.User;
import xyz.vaith.springbootmybatis.repository.UserRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public int insertUser(User user) {
        return userRepository.insertUser(user);
    }

    public User selectByUsername(String username) {
        return userRepository.selectByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void insertGenKey(User user) {
        userRepository.insertGenKey(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }
}
