package br.com.faculdadecatolicapb.ms_pedido.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundExecption.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundExecption execption) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(execption.getMessage());
    }
}
