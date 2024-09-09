package com.example.spring09_jpa.controller;

import com.example.spring09_jpa.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //@ResponseBody 없어도 다 responsebody로 응답
public class MyMemberController1 {
    //http://localhost:8080/member
    @GetMapping("/member1")
    public MemberDto info() {
        MemberDto dto = new MemberDto("hello", "1234", "hello@", 10, null);
        return dto;
    }

    @GetMapping("/list1")
    public List<MemberDto> list() {
        ArrayList<MemberDto> list = new ArrayList<>();
        list.add(new MemberDto("hello", "1234", "hello@", 10, null));
        list.add(new MemberDto("aa", "5555", "aaaa@", 10, null));
        return list;
    }
}


