package com.example.spring09_jpa.controller;

import com.example.spring09_jpa.dto.MemberDto;
import com.example.spring09_jpa.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyMemberController {
    //http://localhost:8080/member
    @GetMapping("/member")
    @ResponseBody // html페이지 없어도 json으로 응답
    public MemberDto info() {
        MemberDto dto = new MemberDto("hello", "1234", "hello@", 10, null);
        return dto;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<MemberDto> list() {
        ArrayList<MemberDto> list = new ArrayList<>();
        list.add(new MemberDto("hello", "1234", "hello@", 10, null));
        list.add(new MemberDto("aa", "5555", "aaaa@", 10, null));
        return list;
    }
}


