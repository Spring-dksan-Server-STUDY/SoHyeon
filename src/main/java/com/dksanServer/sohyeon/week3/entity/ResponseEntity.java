package com.dksanServer.sohyeon.week3.entity;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class ResponseEntity<T> {
    private final int status;
    private final String message;
    private final T body;

    public ResponseEntity(int status, String message, T body) {
        this.status = status;
        this.message = message;
        this.body = body;
    }
}
