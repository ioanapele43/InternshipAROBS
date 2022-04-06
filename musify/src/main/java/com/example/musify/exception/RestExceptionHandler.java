package com.example.musify.exception;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger log= (Logger) LoggerFactory.getLogger(RestExceptionHandler.class);
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> handleIllegal(IllegalArgumentException i){

        ApiError apiError=new ApiError(BAD_REQUEST, i.getMessage());
        log.error("Illegal argument: ",i);
        return new ResponseEntity<>(apiError,BAD_REQUEST);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    protected  ResponseEntity<Object> handleNotFound(EntityNotFoundException e){
        ApiError apiError=new ApiError(BAD_REQUEST, e.getMessage());
        log.error("Not found : ",e);
        return new ResponseEntity<>(apiError,BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorMessages=ex.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        ApiError apiError=new ApiError(BAD_REQUEST,errorMessages);
        log.error("Argument not valid: ",ex);
        return new ResponseEntity<>(apiError,BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
       ApiError apiError= new ApiError(INTERNAL_SERVER_ERROR,"Generic Server Error");
       log.error("Generic Error: "+ex);
       return new ResponseEntity<>(apiError,INTERNAL_SERVER_ERROR);
    }
}