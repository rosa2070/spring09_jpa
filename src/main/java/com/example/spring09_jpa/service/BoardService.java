package com.example.spring09_jpa.service;

import com.example.spring09_jpa.dto.BoardDto;
import com.example.spring09_jpa.dto.MemberDto;
import com.example.spring09_jpa.dto.PageResultDto;
import com.example.spring09_jpa.entity.Board;
import com.example.spring09_jpa.entity.Member;
import com.example.spring09_jpa.repository.BoardRepository;
import com.example.spring09_jpa.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional
public class BoardService {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BoardRepository boardRepository;

    public BoardDto insert(BoardDto dto) {

        Member member = memberRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Member with Id " + dto.getId() + " not found" ));

        Board board = dto.toEntity(member);

        Board savedBoard = boardRepository.save(board);

        return new BoardDto(savedBoard);
    }

    //글목록
    public PageResultDto list(Pageable pageable) {
        Page<Board> page = boardRepository.findAll(pageable);

//        Function<Board, BoardDto> f = new Function<Board, BoardDto>() {
//            @Override
//            public BoardDto apply(Board b) {
//                return new BoardDto(b);
//            }
//        };

//        Function<Board, BoardDto> f = (Board b) -> {
//            return new BoardDto(b);
//        };

//        Function<Board, BoardDto> f = b -> new BoardDto(b);
//        page.stream().map(f);


//        List<BoardDto> dtoList = page.stream().map(b -> new BoardDto(b)).toList();
        List<BoardDto> dtoList = page.stream().map(BoardDto::new).toList();
        PageResultDto pageDto = new PageResultDto(dtoList, page.getNumber(), page.getTotalPages(), 3);

        return pageDto;

    }

    //select (id로 조회) - 수정할 때
    public BoardDto select(Long num) {
        Optional<Board> b = boardRepository.findById(num);
        if (b.isEmpty()) {
            return null;
        } else {
            return new BoardDto(b.get());
        }
    }


    //글수정
    public BoardDto update(BoardDto dto) {
        Member member = memberRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException(("Member with id " + dto.getId() + " not found")));

        Board board = dto.toEntity(member);
        Optional<Board> b1 = boardRepository.findById(board.getNum());
        if (!b1.isEmpty()) {
            Board b2 = b1.get();
            b2.setTitle(dto.getTitle());
            b2.setContent(dto.getContent());
            return new BoardDto(b2);
        }
        return null;

    }

    //글삭제
    public void delete(Long num) {
        boardRepository.deleteById(num);
    }




}
