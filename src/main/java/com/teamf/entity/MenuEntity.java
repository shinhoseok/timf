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

import com.teamf.dto.type.MenuType;
import com.teamf.entity.converter.MenuConverter;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_MENU")
@NoArgsConstructor
@Getter
public class MenuEntity extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id", updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long menuId;
	@Column(name = "menu_cd", length = 20)
	private String menuCd;
	@Column(name = "upr_menu_cd", length = 20)
	private String uprMenuCd;
	@Column(name = "menu_nm", length = 30)
	private String menuNm;
	@Column(name = "menu_type", columnDefinition = "VARCHAR(2)")
	@Convert(converter = MenuConverter.class)
	private MenuType menuType;
	@Column(name = "menu_lvl", length = 3)
	private int menuLvl;
	@Column(name = "order_seq", length = 3)
	private int orderSeq;
	
	@Builder
	public MenuEntity(Long regId, Long modId, boolean delYn, Long menuId, String menuCd, String uprMenuCd, String menuNm, MenuType menuType,
			int menuLvl, int orderSeq, LocalDateTime regDt, LocalDateTime modDt) {
		super(regId, modId, regDt, modDt, delYn);
		this.menuId = menuId;
		this.menuCd = menuCd;
		this.uprMenuCd = uprMenuCd;
		this.menuNm = menuNm;
		this.menuType = menuType;
		this.menuLvl = menuLvl;
		this.orderSeq = orderSeq;
	}
}
