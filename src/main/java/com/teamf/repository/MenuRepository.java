package com.teamf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamf.entity.MenuEntity;

@Repository("menuRepository")
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
