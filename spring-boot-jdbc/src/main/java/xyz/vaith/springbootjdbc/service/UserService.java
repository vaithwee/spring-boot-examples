package xyz.vaith.springbootjdbc.service;

import org.springframework.stereotype.Service;
import xyz.vaith.springbootjdbc.bean.User;
import xyz.vaith.springbootjdbc.repository.UserRepository;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public int insertUser() {
        return userRepository.insertUser();
    }

    public User selectByUsername(String username){
        return userRepository.selectByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User insertGenKey(User user) {
        return userRepository.insertGenKey(user);
    }

    public void updateUser(User user) {
         userRepository.update(user);
    }

    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }
}
