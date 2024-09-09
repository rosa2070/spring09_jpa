package com.example.spring09_jpa.controller;

import com.example.spring09_jpa.dto.PageResultDto;
import com.example.spring09_jpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardListController {
    @Autowired
    private BoardService boardService;
    //http://localhost:8080/board/list?page=0
    @GetMapping("/board/list")
    public String list(@PageableDefault(size=3, sort="num",
                        direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        PageResultDto result = boardService.list(pageable);

        System.out.println("result==>" + result);

        model.addAttribute("list", result.getList());
        model.addAttribute("startPage", result.getStartPage());
        model.addAttribute("endPage", result.getEndPage());
        model.addAttribute("pageCount", result.getTotalPageCount());
        model.addAttribute("page", result.getPage());

        return "board/list";
    };
}
