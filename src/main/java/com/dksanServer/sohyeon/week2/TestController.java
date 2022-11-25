package com.dksanServer.sohyeon.week2;

import com.dksanServer.sohyeon.week3.model.Member;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "안녕하세요!";
    }

    @GetMapping("name/{name}")
    public String getName(@PathVariable(value = "name") final String name) {
        return name;
    }

    @GetMapping("/sopt")
    public String getPart(
            @RequestParam(value = "part", defaultValue = "") final String part,
            @RequestParam(value = "type", defaultValue = "") final String type
    ) {
        return "파트는 " + part + "이고, " + type + "입니다.";
    }

    @PostMapping("user")
    public String postUser(@RequestBody final Member member) {

        return member.getName();
    }

    @PutMapping("user")
    public String putUser(@RequestBody final Member member) {
        return member.getName();
    }

    @DeleteMapping("user")
    public String deleteUser(@RequestBody final Member member) {
        return "delete success";
    }

}
