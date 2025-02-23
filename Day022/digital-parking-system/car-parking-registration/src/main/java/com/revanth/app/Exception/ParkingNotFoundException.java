package com.revanth.app.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ParkingNotFoundException extends RuntimeException {
    public ParkingNotFoundException(String message) {
        super(message);
    }
}

