package com.teamf.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Convert(converter = BooleanToYNConverter.class, attributeName = "delYn")
@SuppressWarnings("serial")
@Entity
@Table(name = "TB_USER")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long userId;
	@Column(name = "user_nm", length = 20)
	private String userNm;
	
	@Builder
	public UserEntity(Long regId, Long modId, Long userId, String userNm, boolean delYn, LocalDateTime regDt, LocalDateTime modDt) {
		super(regId, modId, regDt, modDt, delYn);
		this.userId = userId;
		this.userNm = userNm;
	}
}
