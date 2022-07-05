package com.teamf.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.teamf.dto.type.RoleType;
import com.teamf.entity.converter.RoleConverter;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_ROLE")
@NoArgsConstructor
@Getter
public class RoleEntity extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", updatable = false, columnDefinition = "INT(11)")
	private Long roleId;
	
	@Column(name = "role_cd", columnDefinition = "CHAR(1) DEFAULT '1'")
	@Convert(converter = RoleConverter.class)
	private RoleType roleType;
	
	@Builder
	public RoleEntity(Long roleId, RoleType roleType, boolean delYn, Long regId, Long modId, LocalDateTime regDt, LocalDateTime modDt) {
		super(regId, modId, regDt, modDt, delYn);
		this.roleId = roleId;
		this.roleType = roleType;
	}
}
