package com.praticando_spring.primeiro_projeto_spring.services;

import com.praticando_spring.primeiro_projeto_spring.domain.User;
import com.praticando_spring.primeiro_projeto_spring.exceptions.UserEmailDuplicatedException;
import com.praticando_spring.primeiro_projeto_spring.exceptions.UserExistsException;
import com.praticando_spring.primeiro_projeto_spring.exceptions.UserNotFoundException;
import com.praticando_spring.primeiro_projeto_spring.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(int id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        if (userRepository.existsByEmail(user.getEmail()))
            throw new UserEmailDuplicatedException();

        return userRepository.save(user);
    }

    @Override
    public void deleteById(int id) throws UserNotFoundException {
        User user = findById(id);

        if(user == null)
            throw new UserNotFoundException();

        userRepository.deleteById(id);
    }

    @Override
    public void throwUserNotFoundExceptionTest() throws UserNotFoundException  {
        throw new UserNotFoundException();
    }
}
