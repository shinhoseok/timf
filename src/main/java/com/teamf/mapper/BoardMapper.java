package com.teamf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.teamf.dto.BoardDto;
import com.teamf.entity.BoardEntity;

@Mapper(componentModel = "spring")
public interface BoardMapper {
	
//	public BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);
	
	@Mapping(source = "boardId", target = "boardId")
	public BoardDto toDto(BoardEntity boardEntity);
	
	public BoardEntity toEntity(BoardDto boardDTO);
}
