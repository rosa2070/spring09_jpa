package com.example.spring09_jpa.controller;

import com.example.spring09_jpa.dto.BoardDto;
import com.example.spring09_jpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardInsertController {
    @Autowired
    BoardService boardService;

    @GetMapping("/board/insert")
    public String insertForm() {
        return "board/insert";
    }

    @PostMapping("/board/insert")
    public String insert(@ModelAttribute BoardDto dto, Model model) {
        try {
            boardService.insert(dto);
            model.addAttribute("result", "게시글등록성공!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("result", "게시글등록실패");
        }
        return "board/result";

    }





}
