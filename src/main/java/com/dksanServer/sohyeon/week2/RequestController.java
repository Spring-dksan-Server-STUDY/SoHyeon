package com.dksanServer.sohyeon.week2;

import com.dksanServer.sohyeon.week3.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("request")
@RequiredArgsConstructor
public class RequestController {

    private final EntityManager em;

    @GetMapping("/test")
    public List<Member> test() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    @PostMapping("/user")
    @Transactional
    @ResponseBody
    public Member testPost(@RequestBody final Member member) {
        System.out.println("member: " + member);
        em.persist(member);
        return member;
    }
}
