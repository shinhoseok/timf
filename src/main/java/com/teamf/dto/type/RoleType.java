package com.teamf.dto.type;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleType implements BaseEnumCode<String> {
	USER("사용자권한", "1"),
	ADMIN("관리자권한", "2"),
	ETC("기타", "3");
	
	private String desc;
	private String code;
	
//	RoleType(String desc, String code) {
//		this.desc = desc;
//		this.code = code;
//	}
	
//	public static RoleType getEnum(String code) {
//		RoleType[] roleTypeArr = RoleType.values(); //USER, ADMIN, ETC
//		RoleType roleType = Arrays.stream(roleTypeArr)
//			.filter(v -> v.getCode().equals(code))
//			.findAny()
//			.orElseThrow();
//		return roleType;
//	}
}
