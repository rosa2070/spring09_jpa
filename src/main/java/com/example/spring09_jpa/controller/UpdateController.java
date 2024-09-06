package com.example.spring09_jpa.controller;

import com.example.spring09_jpa.dto.MemberDto;
import com.example.spring09_jpa.entity.Member;
import com.example.spring09_jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateController {
    @Autowired
    MemberService service;

    @GetMapping("/member/update")
    String updateForm(@RequestParam("id") String id, Model model) {
        MemberDto member = service.select(id);
        model.addAttribute("member", member);
        return "member/update";
    }

    @PostMapping("/member/update")
    String update(MemberDto member, Model model) {
        try {
            service.update(member);
            model.addAttribute("result", "회원수정성공!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("result", "회원수정실패");
        }
        return "member/result";
    }
}
