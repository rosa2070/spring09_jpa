package com.example.spring09_jpa.repository;

import com.example.spring09_jpa.entity.Board;
import com.example.spring09_jpa.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

//Board테이블에 테스트 데이터를 10개 넣어보세요.
@SpringBootTest
@Transactional
@Commit
public class BoardRepositoryTest {
    @Autowired
    MemberRepository mr;
    @Autowired
    BoardRepository br;

    @Test
    void insert() {
        Optional<Member> m = mr.findById("bb");
        if(m.isPresent()) {
            Member member = m.get();
//            br.save(new Board(0L, member, "테스트1", "테스트중1...", null));
//            br.save(new Board(0L, member, "테스트2", "테스트중2...", null));
//            br.save(new Board(0L, member, "테스트3", "테스트중3...", null));

            // 10개의 Board 객체를 생성하고 저장
            for(int i=1; i<=10; i++) {
                Board board = Board.builder()
                        .num(0L)
                        .member(member)
                        .title("테스트" + i)
                        .content("테스트중" + i + "...")
                        .build();
                br.save(board);
            }
        }

    }

    @Test
    public void list() {
        PageRequest pageable = PageRequest.of(0, 5);
        Page<Board> page = br.findAll(pageable);
        page.forEach(p -> {
            System.out.println(p);
        });
    }



}
