package com.praticando_spring.primeiro_projeto_spring.services;

import com.praticando_spring.primeiro_projeto_spring.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findById(int id);
    UserDetails findByEmail(String email);
    List<User> findAll();
    User save(User user);
    void deleteById(int id);

    void throwUserNotFoundExceptionTest();
}
