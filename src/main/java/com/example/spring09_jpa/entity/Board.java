package com.example.spring09_jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@ToString(of = {"num", "title", "content", "regdate"})
//@ToString(exclude = {"member"})
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @ToString.Exclude
    private Member member;
    private String title;
    @Lob
    private String content;
    @CreationTimestamp
    private LocalDateTime regdate;

}
