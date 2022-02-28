package com.hello.spring.controller;

import com.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    // 필드 주입 방법
    // @Autowired
    // private MemberService memberService;

    private MemberService memberService;
    // 생성자 주입 방법
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
