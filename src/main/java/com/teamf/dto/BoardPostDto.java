package com.teamf.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class BoardPostDto extends BaseDto implements Serializable {
	private Long postId;
	private String postTitle;
	private String postContent;
	private BoardDto boardDto;
	
	@Builder
	public BoardPostDto(Long regId, Long modId, LocalDateTime regDt, LocalDateTime modDt, boolean delYn, Long postId,
			String postTitle, String postContent, BoardDto boardDto) {
		super(regId, modId, regDt, modDt, delYn);
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.boardDto = boardDto;
	}
}
