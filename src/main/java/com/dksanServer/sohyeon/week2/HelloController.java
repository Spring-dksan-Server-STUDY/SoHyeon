package com.dksanServer.sohyeon.week2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping()
    public String Hello() {
        return "Hello World";
    }
}
