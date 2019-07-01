package xyz.vaith.springbootaop.service;

import xyz.vaith.springbootaop.domain.User;

public interface IUserService {
    void printUser(User user);
    void multipleAspects();
}
