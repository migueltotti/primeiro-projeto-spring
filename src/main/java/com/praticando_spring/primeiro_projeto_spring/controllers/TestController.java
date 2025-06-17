package com.praticando_spring.primeiro_projeto_spring.controllers;

import com.praticando_spring.primeiro_projeto_spring.domain.User;
import com.praticando_spring.primeiro_projeto_spring.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    // Autowired é um anotation que permite a injeção de dependencia sem usar o construtor
    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<String> primeiroEndpoint() {
        return ResponseEntity.ok("primeiro endpoint");
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> customEndpoint(@PathVariable String name) {
        return ResponseEntity.ok("Olá " + name + ", bem vindo ao meu primeiro projeto web com java e spring boot!");
    }

    @PostMapping("/new-user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.ok(String.format("Bem vindo %s, seu email é %s e sua senha é %s",
                user.getName(), user.getEmail(), user.getPassword()));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("user-not-found-exception")
    public ResponseEntity<User> userNotFoundException() {
        userService.throwUserNotFoundExceptionTest();
        return ResponseEntity.ok(new User("Miguel", "miguel@gmail.com", "miguel123"));
    }
}
