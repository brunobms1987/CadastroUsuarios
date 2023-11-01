package com.apiUsuarios.configuration;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.apiUsuarios.dto.error.MensagemErro;
import com.apiUsuarios.exception.PasswordException;
import com.apiUsuarios.exception.UserNotFoundException;

@RestControllerAdvice
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        return new ResponseEntity<>(new MensagemErro(ex.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordException.class)
    public ResponseEntity<MensagemErro> handleUsuarioSenhaErro(PasswordException ex) {
        return new ResponseEntity<>(new MensagemErro(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<MensagemErro> handleUsuarioInexistente(UserNotFoundException ex) {
        return new ResponseEntity<>(new MensagemErro(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
