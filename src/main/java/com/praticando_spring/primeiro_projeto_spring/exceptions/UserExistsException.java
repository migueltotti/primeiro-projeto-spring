package com.praticando_spring.primeiro_projeto_spring.exceptions;

public class UserExistsException extends RuntimeException {
    public UserExistsException() {
        super("Usuário com o mesmo id já existe!");
    }

    public UserExistsException(String mensagem) {
        super(mensagem);
    }
}
