package com.teamf.entity.converter;

import javax.persistence.Converter;

import com.teamf.dto.type.RoleType;

@Converter
public class RoleConverter extends AbstractBaseEnumConverter<RoleType, String> {
	@Override
    protected RoleType[] getValueList() {
        return RoleType.values();
    }
//public class RoleConverter implements AttributeConverter<RoleType, String> {
//	@Override
//	public String convertToDatabaseColumn(RoleType attribute) {
//		return attribute.getCode();
//	}
//	@Override
//	public RoleType convertToEntityAttribute(String dbData) {
//		return RoleType.getEnum(dbData);
//	}
}
