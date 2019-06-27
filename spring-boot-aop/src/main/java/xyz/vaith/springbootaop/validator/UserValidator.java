package xyz.vaith.springbootaop.validator;

import xyz.vaith.springbootaop.domain.User;

public interface UserValidator {
    boolean validate(User user);

}
