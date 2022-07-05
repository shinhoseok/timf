package com.teamf.repository;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamf.dto.type.MenuType;
import com.teamf.dto.type.RoleType;
import com.teamf.entity.MenuEntity;
import com.teamf.entity.ProgramEntity;
import com.teamf.entity.RoleEntity;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest
@SpringBootTest
public class RepositoryTest {
	
	@Resource(name = "roleRepository")
	private RoleRepository roleRepository;
	
	@Resource(name = "programRepository")
	private ProgramRepository programRepository;
	
	@Resource(name = "menuRepository")
	private MenuRepository menuRepository;
	
	@Test
	public void insertRoleProc() {
		roleRepository.save(RoleEntity.builder()
				.roleType(RoleType.USER)
				.delYn(false)
				.build());
		
//		List<RoleEntity> roleList = roleRepository.findAll();
//		RoleEntity roleEntity = roleList.get(0);
		//RegDt>>>>>>2022-05-26T17:28:58.819238>>RegId>>1
//		System.out.println("RegDt>>>>>>"+roleEntity.getRegDt()+">>RegId>>"+roleEntity.getRegId());
	}
	
	@Test
	public void insertProgramMenuProc() {
		//테스트 데이터 ---------------
		MenuEntity menuEntity = MenuEntity.builder()
			.menuCd("MNC-000003")
			.uprMenuCd("MNC-000001")
			.menuNm("프로그램관리")
			.menuType(MenuType.PROGRAM)
			.build();
		menuRepository.save(menuEntity);
		
		programRepository.save(ProgramEntity.builder()
				.programNm("프로그램관리")
				.programUrl("/program")
				.menuEntity(menuEntity)
				.build());
		//테스트 데이터 ---------------
//		ProgramEntity program = programRepository.findByProgramId(1L);
//		MenuEntity menu = program.getMenuEntity();
//		System.out.println("shin>>>>"+menu.getMenuNm()); //프로그램관리
		
//		List<ProgramEntity> programList = programRepository.findAllBy();
//		programList.forEach(e->System.out.println(e));
	}
}
