package com.eil.sms_backend.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiBaseException.class)
    @ResponseBody
    public ResponseEntity<ExceptionDetails> handleHttpMediaTypeNotAcceptable(ApiBaseException ex,WebRequest request) {
        ExceptionDetails exceptionDetails= new ExceptionDetails(ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<ExceptionDetails>(exceptionDetails, ex.getStatusCode());
    }
}
