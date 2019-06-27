package xyz.vaith.springbootbean.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import xyz.vaith.springbootbean.domain.User;

@Service
@Log4j2
public class UserService {
    public void printUser(User user) {
        log.info("编号:" + user.getId());
        log.info("用户名称:" + user.getUserName());
        log.info("备注:" + user.getNote());
    }
}
