package com.example.server.drug.controller;

import com.example.server.drug.entity.Member;
import com.example.server.drug.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MemberController {

    @Autowired
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @GetMapping("/mem")
    public Collection<Member> Members() {
        return memberRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/mem/{id}")
    public Optional<Member> Members(@PathVariable Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member;
    }
    @GetMapping("/member/{user}/{pass}")
    public boolean mem (@PathVariable String user,
                        @PathVariable String pass) {
        Member user1 = memberRepository.findByUser(user);
        String p = user1.getPass();
        System.out.println(user);
        System.out.println(p + " = " + pass);
        return p.matches(pass);
    }
}
