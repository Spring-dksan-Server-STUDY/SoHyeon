package com.dksanServer.sohyeon.week3.controller;

import com.dksanServer.sohyeon.week3.model.Member;
import com.dksanServer.sohyeon.week3.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("")
    @ResponseBody
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
}
