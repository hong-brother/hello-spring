package com.hello.spring.controller;

import com.hello.spring.domain.Member;
import com.hello.spring.dto.MemberDto;
import com.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("/member/new")
    public ResponseEntity create(@RequestBody() MemberDto memberDto) {
        Member member = new Member();
        member.setName(memberDto.getName());
        memberService.join(member);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/members")
    public ResponseEntity list() {
        List<Member> members = memberService.findMembers();
        return ResponseEntity.ok(members);
    }

}
