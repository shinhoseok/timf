package com.teamf.test;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper // 1
public interface OrderMapper {
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class); // 2

	@Mapping(target = "id", constant = "0L") // 3
	Order orderDtoToEntity(OrderDto orderDto);

	@Mapping(target = "img", expression = "java(order.getProduct() + \".jpg\")") // 4
	OrderDto orderToDto(Order order);
}
