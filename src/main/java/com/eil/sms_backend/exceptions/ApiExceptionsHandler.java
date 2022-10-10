package com.eil.sms_backend.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiBaseException.class)
    @ResponseBody
    protected ResponseEntity<ExceptionDetails> handleHttpMediaTypeNotAcceptable(ApiBaseException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionDetails exceptionDetails= new ExceptionDetails(ex.getMessage(),"description .... ");
        System.out.println("*********************************");
        return new ResponseEntity<ExceptionDetails>(exceptionDetails, ex.getStatusCode());
    }
}
