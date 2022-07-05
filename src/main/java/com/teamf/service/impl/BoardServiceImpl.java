package com.teamf.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamf.dto.BoardDto;
import com.teamf.dto.BoardPostDto;
import com.teamf.entity.BoardEntity;
import com.teamf.entity.BoardPostEntity;
import com.teamf.mapper.BoardMapper;
import com.teamf.mapper.BoardPostMapper;
import com.teamf.repository.BoardPostRepository;
import com.teamf.repository.BoardRepository;
import com.teamf.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	protected Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Resource(name = "boardPostMapperImpl")
	private BoardPostMapper boardPostMapper;
	
	@Resource(name = "boardRepository")
	private BoardRepository boardRepository;
	
	@Resource(name = "boardPostRepository")
	private BoardPostRepository boardPostRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Resource(name = "entityManagerFactory")
	private EntityManagerFactory entityManagerFactory;
	
	public void selectBoardList(BoardPostDto boardPostDto) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			
			em.getTransaction().begin();
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		entityManagerFactory.close();
	}
	
	public void deleteBoardRelationProc(BoardPostDto boardPostDto) throws Exception {
//		EntityManager em = entityManagerFactory.createEntityManager();
//		em.getTransaction().begin();
//		List<BoardEntity> boardList = em.
//		BoardPostEntity boardPostEntity = em.find(BoardPostEntity.class, boardPostDto.getPostId());
//		BoardEntity boardEntity = boardPostEntity.getBoardEntity();
//		boardPostEntity.setBoardEntity(null);
//		log.debug("shin2>>>"+boardEntity.toString()); //자유게시판
//		em.remove(boardEntity);
		
//		em.getTransaction().commit();
	}
	
	public void updateBoardRelactionProc(BoardPostDto boardPostDto) throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		BoardPostEntity boardPostEntity = em.find(BoardPostEntity.class, boardPostDto.getPostId());
		boardPostEntity.setBoardEntity(null);
		em.getTransaction().commit();
	}
	
	public void updateBoardProc(BoardPostDto boardPostDto) throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		//게시판 생성
		BoardDto boardDto = BoardDto.builder()
				.boardNm("자유게시판")
				.delYn(false)
				.regId(1L)
				.build();
		BoardEntity boardEntity = boardMapper.toEntity(boardDto);
		em.persist(boardEntity);
		//게시물 수정
		BoardPostEntity boardPostEntity = em.find(BoardPostEntity.class, boardPostDto.getPostId());
		boardPostEntity.setBoardEntity(boardEntity);
		
		em.getTransaction().commit();
		System.out.println("shin1>>>"+boardPostEntity.getBoardEntity().toString());
	}
	
	public void insertBoardProc(BoardDto boardDto) throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		BoardEntity boardEntity = boardMapper.toEntity(boardDto);
		em.persist(boardEntity);
		
		BoardPostDto boardPostDto1 = BoardPostDto.builder()
				.postTitle("테스트제목1")
				.postContent("내용1")
				.build();
		BoardPostEntity boardPostEntity1 = boardPostMapper.toEntity(boardPostDto1);
		boardPostEntity1.setBoardEntity(boardEntity);
		em.persist(boardPostEntity1);
		
		BoardPostDto boardPostDto2 = BoardPostDto.builder()
				.postTitle("테스트제목2")
				.postContent("내용2")
				.build();
		BoardPostEntity boardPostEntity2 = boardPostMapper.toEntity(boardPostDto2);
		boardPostEntity2.setBoardEntity(boardEntity);
		em.persist(boardPostEntity2);
		
		em.getTransaction().commit();
	}
}
