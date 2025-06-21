package com.praticando_spring.primeiro_projeto_spring.controllers;

import com.praticando_spring.primeiro_projeto_spring.domain.LoginDTO;
import com.praticando_spring.primeiro_projeto_spring.domain.RegisterDTO;
import com.praticando_spring.primeiro_projeto_spring.domain.TokenResponseDTO;
import com.praticando_spring.primeiro_projeto_spring.domain.User;
import com.praticando_spring.primeiro_projeto_spring.infra.security.TokenService;
import com.praticando_spring.primeiro_projeto_spring.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody @Valid LoginDTO login){
        var usernamePassword = new UsernamePasswordAuthenticationToken(login.email(), login.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        // auth.getPrincipal() vai pegar o objeto que representa a authenticação com sucesso que fizemos
        // (User) vai fazer um cast e transformar esse objeto em User

        var expirationTime = LocalDateTime.now().plusHours(1).atOffset(ZoneOffset.of("-03:00"));

        return ResponseEntity.ok(new TokenResponseDTO(token, expirationTime));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO register){
        if(this.userService.findByEmail(register.email()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(register.password());
        User newUser = new User(register.name(), register.email(), encryptedPassword, register.role());

        this.userService.save(newUser);

        return ResponseEntity.ok().build();
    }
}
