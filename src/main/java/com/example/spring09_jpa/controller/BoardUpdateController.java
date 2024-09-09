package com.example.spring09_jpa.controller;

import com.example.spring09_jpa.dto.BoardDto;
import com.example.spring09_jpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardUpdateController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/update")
    String updateForm(@RequestParam("num") Long num, Model model) {
        BoardDto board = boardService.select(num);
        model.addAttribute("board", board);
        return "board/update";
    }

    @PostMapping("/board/update")
    String update(BoardDto board, Model model) {
        try {
            boardService.update(board);
            model.addAttribute("result", "회원수정성공!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("result", "회원수정실패");
        }
        return "board/result";
    }

}
