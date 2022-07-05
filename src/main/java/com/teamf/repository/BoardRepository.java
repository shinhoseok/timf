package com.teamf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamf.entity.BoardEntity;

@Repository("boardRepository")
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
	
}
