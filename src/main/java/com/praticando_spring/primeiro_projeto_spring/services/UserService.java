package com.praticando_spring.primeiro_projeto_spring.services;

import com.praticando_spring.primeiro_projeto_spring.domain.User;
import com.praticando_spring.primeiro_projeto_spring.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User("miguel", "miguel@gmail.com", "miguel123"));
        users.add(new User("isadora", "isadora@gmail.com", "isadora123"));

        return users;
    }

    @Override
    public void throwUserNotFoundExceptionTest() {
        throw new UserNotFoundException();
    }
}
