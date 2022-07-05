package com.teamf.entity.converter;

import javax.persistence.Converter;

import com.teamf.dto.type.MenuType;

@Converter
public class MenuConverter extends AbstractBaseEnumConverter<MenuType, String> {
	@Override
	protected MenuType[] getValueList() {
		return MenuType.values();
	}
}
