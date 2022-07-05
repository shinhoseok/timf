package com.teamf.service;

import com.teamf.dto.BoardDto;
import com.teamf.dto.BoardPostDto;

public interface BoardService {
	public void insertBoardProc(BoardDto boardDto) throws Exception;
	
	public void updateBoardProc(BoardPostDto boardPostDto) throws Exception;
	
	public void updateBoardRelactionProc(BoardPostDto boardPostDto) throws Exception;
	
	public void deleteBoardRelationProc(BoardPostDto boardPostDto) throws Exception;
}
