package xyz.vaith.springbootaop.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import xyz.vaith.springbootaop.domain.User;
import xyz.vaith.springbootaop.service.IUserService;

@Log4j2
@Service
public class IUserServiceImpl implements IUserService {
    @Override
    public void printUser(User user) {
        if (user == null) {
            throw new RuntimeException("user is null");

        }
        log.info("id: " + user.getId());
        log.info("username: " + user.getUsername());
        log.info("note: " + user.getNote());
    }
}
