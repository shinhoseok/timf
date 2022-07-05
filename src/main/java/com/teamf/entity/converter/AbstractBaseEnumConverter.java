package com.teamf.entity.converter;

import java.util.Arrays;

import javax.persistence.AttributeConverter;

import com.teamf.dto.type.BaseEnumCode;

public abstract class AbstractBaseEnumConverter <X extends Enum<X> & BaseEnumCode<Y>, Y>
		implements AttributeConverter<X, Y> {
	
	protected abstract X[] getValueList();

	@Override
	public Y convertToDatabaseColumn(X attribute) {
		return attribute.getCode();
	}

	@Override
	public X convertToEntityAttribute(Y dbData) {
		return Arrays.stream(getValueList())
				.filter(e -> e.getCode().equals(dbData))
				.findFirst()
				.orElse(null);
	}
}
