package com.example.spring09_jpa.repository;

import com.example.spring09_jpa.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {
    public Page<Member> findAll(Pageable pageable);

    // limit: 몇개, offset : 몇페이지서부터
    @Query("select m from Member m where m.age>:age order by m.age desc limit :a offset :b")
    public List<Member> findList(@Param("age") int age, @Param("a") int a, @Param("b") int b);

    @Modifying //DML작업할 때는 반드시 어노테이션을 설정해야 함
    @Query("update Member m set m.age = m.age+10 where m.id=:id")
    public int update(@Param("id") String id);


}
