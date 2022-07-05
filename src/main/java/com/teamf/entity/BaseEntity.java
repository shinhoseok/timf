package com.teamf.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.teamf.entity.converter.BooleanToYNConverter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
	
	@CreatedBy
	@Column(name="reg_id", updatable = false, columnDefinition = "INT(11)")
	private Long regId;
	
	@Column(name = "reg_dt", updatable = false)
	@CreatedDate
	private LocalDateTime regDt;
	
	@LastModifiedBy
	@Column(name="mod_id", columnDefinition = "INT(11)")
	private Long modId;
	
	@LastModifiedDate
	@Column(name = "mod_dt")
	private LocalDateTime modDt;
	
	@Convert(converter = BooleanToYNConverter.class)
	@Column(name = "delyn", columnDefinition = "CHAR(1) DEFAULT 'N'")
	private boolean delYn;
	
	public BaseEntity(Long regId, Long modId, LocalDateTime regDt, LocalDateTime modDt, boolean delYn) {
		this.regId = regId;
		this.modId = modId;
		this.regDt = regDt;
		this.modDt = modDt;
		this.delYn = delYn;
	}
}
