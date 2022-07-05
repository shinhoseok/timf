package com.teamf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.teamf.dto.BoardPostDto;
import com.teamf.entity.BoardPostEntity;

@Mapper(componentModel = "spring")
public interface BoardPostMapper {
	
	@Mapping(source = "boardEntity", target = "boardDto")
	public BoardPostDto toDto(BoardPostEntity boardPostEntity);
	
	@Mapping(source = "boardDto", target = "boardEntity")
	public BoardPostEntity toEntity(BoardPostDto boardPostDto);
}
