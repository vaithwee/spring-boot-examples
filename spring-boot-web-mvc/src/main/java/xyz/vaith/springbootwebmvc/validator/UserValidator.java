package xyz.vaith.springbootwebmvc.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import xyz.vaith.springbootwebmvc.pojo.User;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (o == null) {
            errors.rejectValue("", null, "用户名不能为空");
            return;
        }
        User user = (User) o;
        if (StringUtils.isEmpty(user.getUsername())) {
            errors.rejectValue("username", null, "用户名不能为空");
        }
    }
}
