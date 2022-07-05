package com.teamf.service;


import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.Resource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamf.dto.BoardDto;
import com.teamf.dto.BoardPostDto;
import com.teamf.entity.BoardEntity;
import com.teamf.mapper.BoardMapper;
import com.teamf.mapper.BoardPostMapper;
import com.teamf.repository.BoardPostRepository;
import com.teamf.repository.BoardRepository;

@SpringBootTest
public class ServiceTest {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Resource(name = "boardPostMapperImpl")
	private BoardPostMapper boardPostMapper;
	
	@Resource(name = "boardRepository")
	private BoardRepository boardRepository;
	
	@Resource(name = "boardPostRepository")
	private BoardPostRepository boardPostRepository;
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	@Test
	void deleteBoardRelationProc() throws Exception {
		BoardPostDto boardPostDto = BoardPostDto.builder()
				.postId(11L)
				.build();
		boardService.deleteBoardRelationProc(boardPostDto);
	}
	
//	@Test
	void updateBoardRelationProc() throws Exception {
		BoardPostDto boardPostDto = BoardPostDto.builder()
				.postId(11L)
				.build();
		boardService.updateBoardRelactionProc(boardPostDto);
	}
	
//	@Test
	void updateBoardProc() throws Exception {
		BoardPostDto boardPostDto = BoardPostDto.builder()
				.postId(11L)
				.build();
		boardService.updateBoardProc(boardPostDto);
	}
	
//	@Test
	void insertBoardProc() throws Exception {
		BoardDto boardDto = BoardDto.builder()
				.boardNm("공지사항")
				.delYn(false)
				.regId(1L)
				.build();
		
		boardService.insertBoardProc(boardDto);
	}
	
//	@Test
	@DisplayName("DTO에서 Entity로 변환하는 테스트")
	void toDto() {
		BoardEntity boardEntity = BoardEntity.builder()
				.boardId(1L)
				.boardNm("공지사항")
				.delYn(true)
				.regId(1L)
				.build();
		
		BoardDto boardDTO = boardMapper.toDto(boardEntity);
		System.out.println("toDto>>>>>>>>>>");
		System.out.println(boardDTO.toString()); //BoardDTO(boardId=1, boardNm=공지사항)
	}
	
//	@Test
	@DisplayName("Entity에서 Dto로 변환하는 테스트")
	void toEntity() {
		BoardDto boardDTO = BoardDto.builder()
				.boardId(2L)
				.boardNm("Q&A")
				.delYn(true)
				.regId(2L)
				.build();
		
		BoardEntity boardEntity = boardMapper.toEntity(boardDTO);
		System.out.println("toEntity");
		System.out.println(boardDTO.getBoardNm());
		assertThat(boardDTO.getRegId()).isEqualTo(boardEntity.getRegId());
	}
}
