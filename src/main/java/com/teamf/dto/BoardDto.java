package com.teamf.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings({ "serial" })
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardDto extends BaseDto implements Serializable {
	private Long boardId;
	private String boardNm;
	
	@Builder
	public BoardDto(Long regId, Long modId, LocalDateTime regDt, LocalDateTime modDt, 
			boolean delYn, Long boardId, String boardNm) {
		super(regId, modId, regDt, modDt, delYn);
		this.boardId = boardId;
		this.boardNm = boardNm;
	}
}
