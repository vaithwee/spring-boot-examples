package xyz.vaith.springbootjpa.service;

import org.springframework.stereotype.Service;
import xyz.vaith.springbootjpa.bean.User;
import xyz.vaith.springbootjpa.repository.UserRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        Optional<User> op = userRepository.findById(id);
        return op.get();
    }

    @Transactional
    public void update(User user) {
        user.setUsername("孙悟空");
        user.setLoginName("swk");
    }
}
