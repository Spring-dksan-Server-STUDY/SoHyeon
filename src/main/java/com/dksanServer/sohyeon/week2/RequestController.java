package com.dksanServer.sohyeon.week2;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("request")
@RequiredArgsConstructor
public class RequestController {

    private final EntityManager em;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/user")
    @Transactional
    public Long testPost(@RequestBody final Member member) {
        System.out.println("member: " + member);
        em.persist(member);
        return member.getId();
    }
}
