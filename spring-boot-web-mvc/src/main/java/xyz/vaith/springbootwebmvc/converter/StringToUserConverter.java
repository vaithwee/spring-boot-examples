package xyz.vaith.springbootwebmvc.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import xyz.vaith.springbootwebmvc.pojo.User;

@Component
public class StringToUserConverter implements Converter<String, User> {
    @Override
    public User convert(String s) {
        User user = new User();
        String[] strArr = s.split("-");
        Long id = Long.parseLong(strArr[0]);
        String username = strArr[1];
        String note = strArr[2];
        user.setId(id);
        user.setUsername(username);
        user.setNote(note);
        return user;
    }
}
