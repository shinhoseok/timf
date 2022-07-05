package com.teamf.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import com.teamf.test.Order;
import com.teamf.test.OrderDto;
import com.teamf.test.OrderMapper;

public class MainTest {
	public static void main(String[] args) {
		/* given */
        final OrderDto orderDto = OrderDto.builder()
                .name("테스트")
                .product("사탕")
                .price(1000)
                .address("Seoul")
                .orderedTime(LocalDateTime.now())
                .build();
        /* when */
        final Order order = OrderMapper.INSTANCE.orderDtoToEntity(orderDto);
        /* then */
        assertNotNull(order);
        assertThat(order.getName()).isEqualTo("테스트");
        assertThat(order.getProduct()).isEqualTo("사탕");
        assertThat(order.getPrice()).isEqualTo(1000);
        assertThat(order.getAddress()).isEqualTo("Seoul");
        assertThat(order.getOrderedTime()).isBefore(LocalDateTime.now());
        assertThat(order.getId()).isEqualTo(0L);
	}
}
