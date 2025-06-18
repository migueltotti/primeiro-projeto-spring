package com.praticando_spring.primeiro_projeto_spring.controllers;

import com.praticando_spring.primeiro_projeto_spring.domain.User;
import com.praticando_spring.primeiro_projeto_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    // Autowired é um anotation que permite a injeção de dependencia sem usar o construtor
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String> primeiroEndpoint() {
        return ResponseEntity.ok("primeiro endpoint");
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> customEndpoint(@PathVariable String name) {
        return ResponseEntity.ok("Olá " + name + ", bem vindo ao meu primeiro projeto web com java e spring boot!");
    }

    @GetMapping("user-not-found-exception")
    public ResponseEntity<User> userNotFoundException() {
        userService.throwUserNotFoundExceptionTest();
        return ResponseEntity.ok(new User(1, "Miguel", "miguel@gmail.com", "miguel123"));
    }

    @GetMapping("/query")
    public ResponseEntity<String> queryData(@RequestParam String dado) {
        return ResponseEntity.ok("Olha só, você acabou de usar um queryString para passar um dado pela requisição.\n" +
                "Dado passado via queryString: " + dado);
    }
}
