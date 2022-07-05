package com.teamf.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_BOARD_POST")
@NoArgsConstructor
@Getter
@Setter
public class BoardPostEntity extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id", columnDefinition = "INT(11)")
	private Long postId;
	@Column(name = "post_title", length = 100)
	private String postTitle;
	@Column(name = "post_content", length = 500)
	private String postContent;
	@ManyToOne
	@JoinColumn(name = "board_id")
	private BoardEntity boardEntity;
	
	@Builder
	public BoardPostEntity(Long regId, Long modId, LocalDateTime regDt, LocalDateTime modDt, boolean delYn, Long postId,
			String postTitle, String postContent, BoardEntity boardEntity) {
		super(regId, modId, regDt, modDt, delYn);
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.boardEntity = boardEntity;
	}
}
