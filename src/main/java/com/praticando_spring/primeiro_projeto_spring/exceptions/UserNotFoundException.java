package com.praticando_spring.primeiro_projeto_spring.exceptions;

// Precisamos extender a classe de Exception com o RuntimeException para que seja possivel lançar a
// exceção e depois capitura-la para tratar da forma correta.
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() { super("User not found!"); }
    public UserNotFoundException(String message) { super(message); }
}
