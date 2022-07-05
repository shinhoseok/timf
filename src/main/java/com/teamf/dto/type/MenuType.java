package com.teamf.dto.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MenuType implements BaseEnumCode<String> {
	PROGRAM("프로그램", "1"),
	BOARD("게시판", "2"),
	CONTENTS("컨텐츠", "3"),
	LINK("링크", "4");
	
	private String desc;
	private String code;
}
