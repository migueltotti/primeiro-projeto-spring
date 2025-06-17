package com.praticando_spring.primeiro_projeto_spring.services;

import com.praticando_spring.primeiro_projeto_spring.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service define um serviço na aplicação e permite que essa classe seja injetada via injeção de dependencia
@Service
public interface IUserService {
    List<User> getUsers();
    void throwUserNotFoundExceptionTest();
}
