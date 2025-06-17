package com.praticando_spring.primeiro_projeto_spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter // Define os setters automaticamente.
@Getter // define os getters automaticamente.
@AllArgsConstructor // define um construtor com todos os argumentos automaticamente.
public class User {
    private String name;
    private String email;
    private String password;
}
