package com.praticando_spring.primeiro_projeto_spring.domain;

public record RegisterDTO(String name, String email, String password, UserRole role) {
}
