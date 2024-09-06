package com.example.spring09_jpa.dto;

import com.example.spring09_jpa.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {
    private String id;
    private String pwd;
    private String email;
    private int age;
    private Date regdate;

    public MemberDto(Member mem) {
        this.id = mem.getId();
        this.pwd = mem.getPwd();
        this.email = mem.getEmail();
        this.age = mem.getAge();
        this.regdate = mem.getRegdate();
    }

    public Member toEntity() {
        Member m = new Member(id, pwd, email, age, regdate);
        return m;
    }


}
