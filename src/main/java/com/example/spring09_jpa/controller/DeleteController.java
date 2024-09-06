package com.example.spring09_jpa.controller;

import com.example.spring09_jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {
    @Autowired
    MemberService service;

    @GetMapping("/member/delete")
    public String delete(@RequestParam("id") String id, Model model) {
        service.delete(id);
        return "redirect:/member/list";

    }
}
