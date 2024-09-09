package com.example.spring09_jpa.repository;

import com.example.spring09_jpa.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MemberRepositoryTest {
    @Autowired
    MemberRepository mr;

    @Test
    void insert() {
        mr.save(new Member("bb", "2", "bb@", 71, null));
        mr.save(new Member("cc", "2", "cc@", 7, null));
        mr.save(new Member("dd", "2", "dd@", 22, null));
        mr.save(new Member("ee", "2", "ee@", 15, null));
        mr.save(new Member("ff", "2", "ff@", 8, null));
        mr.save(new Member("gg", "2", "gg@", 88, null));
        mr.save(new Member("kk", "2", "kk@", 33, null));
        mr.save(new Member("jj", "2", "jj@", 44, null));
    }

    @Test
    void pageTest() {
        PageRequest pageRequest = PageRequest.of(1, 3);
        Page<Member> page = mr.findAll(pageRequest);
        System.out.println("전체 페이지 수: " + page.getTotalPages());
        System.out.println("현재 페이지: " + page.getNumber());
        List<Member> list = page.getContent();
//        page.forEach(e -> {
//            System.out.println(e);
//        });
        list.forEach(e -> {
            System.out.println(e);
        });
    }

    @Test
    public void pageTest1() {
        PageRequest pageRequest = PageRequest.of(1, 3, Sort.by("id").descending());
        Page<Member> list = mr.findAll(pageRequest);
        List<Member> result = list.getContent();
        for(Member m : result) {
            System.out.println(m);
        }
    }

    @Test
    void pageTest2() {
        // 0페이지에서 10살이상 데이터를 5개 꺼내오기
        List<Member> list = mr.findList(10, 5, 0);
        list.forEach(m -> {
            System.out.println(m);
        });
    }

    @Test
    void update() {
        int n = mr.update("bb");
        System.out.println("==>" + n);
    }
}
