package com.praticando_spring.primeiro_projeto_spring.exceptions;

public class UserEmailDuplicatedException extends RuntimeException {
    public UserEmailDuplicatedException() {
        super("Usuário com esse email já existe!");
    }
    public UserEmailDuplicatedException(String message) {
        super(message);
    }
}
