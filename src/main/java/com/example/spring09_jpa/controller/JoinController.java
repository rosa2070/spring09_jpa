package com.example.spring09_jpa.controller;

import com.example.spring09_jpa.dto.MemberDto;
import com.example.spring09_jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {
    @Autowired MemberService service;

    @GetMapping("/member/join")
    String joinForm() {
        return "member/join";
    }

    @PostMapping("/member/join")
    String join(@ModelAttribute MemberDto dto, Model model) {
        try {
            service.join(dto);
            model.addAttribute("result", "회원가입성공!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("result", "회원가입실패");
        }
        return "member/result";

    }

}
