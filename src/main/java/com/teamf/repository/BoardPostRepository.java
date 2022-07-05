package com.teamf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamf.entity.BoardPostEntity;

@Repository("boardPostRepository")
public interface BoardPostRepository extends JpaRepository<BoardPostEntity, Long> {

}
