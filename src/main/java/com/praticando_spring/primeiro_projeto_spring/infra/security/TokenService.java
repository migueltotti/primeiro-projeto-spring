package com.praticando_spring.primeiro_projeto_spring.infra.security;

import com.praticando_spring.primeiro_projeto_spring.domain.User;

public interface TokenService {
    String generateToken(User user);
    String validateToken(String token);
}
