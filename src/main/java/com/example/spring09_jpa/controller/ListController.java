package com.example.spring09_jpa.controller;

import com.example.spring09_jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {
    @Autowired
    MemberService service;

    @GetMapping("/member/list")
    public String list(Model model) {
        model.addAttribute("list", service.list());

        return "member/list";
    }
}
