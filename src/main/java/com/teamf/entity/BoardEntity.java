package com.teamf.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_BOARD")
@NoArgsConstructor
@Getter
@ToString
public class BoardEntity extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_id", columnDefinition = "INT(11)")
	private Long boardId;
	@Column(name = "board_nm", length = 30)
	private String boardNm;
	@OneToMany(mappedBy = "boardEntity")
	private List<BoardPostEntity> boardPostList = new ArrayList<>();
	@Builder
	public BoardEntity(Long regId, Long modId, LocalDateTime regDt, 
			LocalDateTime modDt, boolean delYn, Long boardId, String boardNm) {
		super(regId, modId, regDt, modDt, delYn);
		this.boardId = boardId;
		this.boardNm = boardNm;
	}
}
