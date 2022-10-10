package com.eil.sms_backend.exceptions;

import org.springframework.http.HttpStatus;

public class ItemsNotFoundException extends ApiBaseException{
    public ItemsNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
