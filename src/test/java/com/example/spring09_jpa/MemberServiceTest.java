package com.example.spring09_jpa;

import com.example.spring09_jpa.dto.MemberDto;
import com.example.spring09_jpa.entity.Member;
import com.example.spring09_jpa.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
@Slf4j
public class MemberServiceTest {
    @Autowired
    private MemberService service;

    @Test
    void save() {
        service.join(new MemberDto("hello", "1234", "hello@", 10, null));
        service.join(new MemberDto("test", "5678", "test@", 20, null));
    }

    @Test
    void list() {
        List<MemberDto> list1 = service.list();
        list1.forEach(m -> {
            log.info(m.toString());
        });
    }

    @Test
    void delete() {
        service.delete("hello");
    }

    @Test
    void select() {
        MemberDto dto = service.select("test");
        log.info("member -> {}", dto.toString());
    }

    @Test
    void update() {
        MemberDto newMember = service.update(new MemberDto("test", "7777", "test@@", 10, null));
        log.info("member -> {}", newMember);
    }


}
