package com.praticando_spring.primeiro_projeto_spring.errors;

import com.praticando_spring.primeiro_projeto_spring.exceptions.UserEmailDuplicatedException;
import com.praticando_spring.primeiro_projeto_spring.exceptions.UserExistsException;
import com.praticando_spring.primeiro_projeto_spring.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// @ControllerAdvice configura uma classe que vai conter a lógica e a configuração de tratamento de
// exceções em controllers ou qualquer fluxo de execução que pertenca a um controller
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // @ExceptionHandler define um metodo que vai tratar a exceção e retornar o erro correto
    // É preciso definir qual erro vamos tratar com esse ExceptionHandler()
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<RestErrorMessage> userNotFoundHandler(UserNotFoundException ex){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<RestErrorMessage> userExistsHandler(UserExistsException ex){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }

    @ExceptionHandler(UserEmailDuplicatedException.class)
    public ResponseEntity<RestErrorMessage> userEmailDuplicatedHandler(UserEmailDuplicatedException ex){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
}
