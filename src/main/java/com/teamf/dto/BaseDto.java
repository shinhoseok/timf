package com.teamf.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
public class BaseDto implements Serializable {
	private Long regId;
	private LocalDateTime regDt;
	private Long modId;
	private LocalDateTime modDt;
	private boolean delYn;

	public BaseDto(Long regId, Long modId, LocalDateTime regDt, 
			LocalDateTime modDt, boolean delYn) {
		this.regId = regId;
		this.modId = modId;
		this.regDt = regDt;
		this.modDt = modDt;
		this.delYn = delYn;
	}
}

