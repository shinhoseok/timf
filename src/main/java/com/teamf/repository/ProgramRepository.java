package com.teamf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamf.entity.MenuEntity;
import com.teamf.entity.ProgramEntity;

@Repository("programRepository")
public interface ProgramRepository extends JpaRepository<ProgramEntity, Long> {
	
	public ProgramEntity findByMenuEntity(MenuEntity menuEntity);
	
	public ProgramEntity findByProgramId(Long programId);
	
	public List<ProgramEntity> findAllBy();
}
