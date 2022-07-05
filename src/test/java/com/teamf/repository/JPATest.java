package com.teamf.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamf.entity.BoardEntity;
import com.teamf.entity.BoardPostEntity;

@SpringBootTest
public class JPATest {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Test
	public void insertBoardProc() {
		System.out.println("insertBoardProc>>>>>>");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		BoardEntity boardEntity = BoardEntity.builder()
				.boardNm("공지사항")
				.delYn(false)
				.build();
		entityManager.persist(boardEntity);
		
		BoardPostEntity boardPostEntity1 = BoardPostEntity.builder()
				.postTitle("공지제목1")
				.postContent("공지내용")
				.delYn(false)
				.boardEntity(boardEntity)
				.build();
		entityManager.persist(boardPostEntity1);
		
		BoardPostEntity boardPostEntity2 = BoardPostEntity.builder()
				.postTitle("공지제목2")
				.postContent("공지내용2")
				.delYn(false)
				.boardEntity(boardEntity)
				.build();
		entityManager.persist(boardPostEntity2);
	}
}
