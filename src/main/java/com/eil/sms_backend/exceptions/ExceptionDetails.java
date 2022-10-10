package com.eil.sms_backend.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@Data@NoArgsConstructor
public class ExceptionDetails {

    private String message;
    private String description;
}
