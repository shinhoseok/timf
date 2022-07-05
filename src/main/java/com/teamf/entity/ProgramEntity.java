package com.teamf.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_PROGRAM")
@NoArgsConstructor
@Getter
public class ProgramEntity extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "program_id", updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long programId;
	
	@Column(name = "program_nm", length = 30)
	private String programNm;
	
	@Column(name = "program_url", length = 50)
	private String programUrl;
	
	@Column(name = "program_desc", length = 200)
	private String programDesc;
	
	@Column(name = "program_param", length = 20)
	private String programParam;
	
	@OneToOne
	@JoinColumn(name = "menu_id")
	private MenuEntity menuEntity;
	
	@Builder
	public ProgramEntity(Long regId, Long modId, LocalDateTime regDt, LocalDateTime modDt, boolean delYn, Long programId,
			String programNm, String programUrl, String programDesc, String programParam, MenuEntity menuEntity) {
		super(regId, modId, regDt, modDt, delYn);
		this.programId = programId;
		this.programNm = programNm;
		this.programUrl = programUrl;
		this.programDesc = programDesc;
		this.programParam = programParam;
		this.menuEntity = menuEntity;
	}
}
