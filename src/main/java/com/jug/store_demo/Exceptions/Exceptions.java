package com.jug.store_demo.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class Exceptions {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus errorCode;
    private final ZonedDateTime timestamp;
}
