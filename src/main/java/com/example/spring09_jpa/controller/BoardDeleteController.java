package com.example.spring09_jpa.controller;

import com.example.spring09_jpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardDeleteController {
    @Autowired
    BoardService boardService;

    @GetMapping("/board/delete")
    public String delete(@RequestParam("num") Long num, Model model) {
        boardService.delete(num);
        return "redirect:/board/list";
    }

}
