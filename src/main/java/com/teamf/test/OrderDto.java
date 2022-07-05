package com.teamf.test;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class OrderDto {
	private String name;
	private String product;
	private Integer price;
	private String address;
	private String img;
	private LocalDateTime orderedTime;
}
