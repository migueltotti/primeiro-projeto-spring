package com.praticando_spring.primeiro_projeto_spring.services;

import com.praticando_spring.primeiro_projeto_spring.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findById(int id);
    List<User> findAll();
    User save(User user);
    void deleteById(int id);

    void throwUserNotFoundExceptionTest();
}
