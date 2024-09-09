package com.example.spring09_jpa.repository;

import com.example.spring09_jpa.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
