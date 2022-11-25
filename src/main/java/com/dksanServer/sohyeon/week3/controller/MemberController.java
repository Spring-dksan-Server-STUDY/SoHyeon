package com.dksanServer.sohyeon.week3.controller;

import com.dksanServer.sohyeon.week3.model.Member;
import com.dksanServer.sohyeon.week3.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("")
    @ResponseBody
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
}
