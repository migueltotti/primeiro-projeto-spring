package com.praticando_spring.primeiro_projeto_spring.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.praticando_spring.primeiro_projeto_spring.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${api.security.token.security}")
    private String secret;
    @Override
    public String generateToken(User user) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withSubject(user.getEmail())
                    .withIssuer("primeiro-projeto-api")
                    .withAudience("por enquanto nenhuma")
                    .withExpiresAt(getExpirationInstant())
                    .sign(algorithm);

            return token;
        }catch (JWTCreationException ex){
            throw new RuntimeException("Error generating token", ex);
        }
    }

    @Override
    public String validateToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("primeiro-projeto-api")
                    .withAudience("por enquanto nenhuma")
                    .build()
                    .verify(token)
                    .getSubject();

        }catch (JWTVerificationException ex){
            return "";
        }
    }

    private Instant getExpirationInstant() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
