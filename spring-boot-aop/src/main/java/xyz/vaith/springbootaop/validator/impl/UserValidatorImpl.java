package xyz.vaith.springbootaop.validator.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import xyz.vaith.springbootaop.domain.User;
import xyz.vaith.springbootaop.validator.UserValidator;

@Log4j2
@Component
public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validate(User user) {
       log.info("import new interface: " + UserValidator.class.getCanonicalName());
       return user != null;
    }
}
