package com.food.domain.repository;

import java.util.List;

import com.food.domain.model.Permission;

public interface PermissionRepository {

	List<Permission> findAll();
	Permission findById(Long id);
	Permission add(Permission permission);
	void remove(Permission permission);
	
}
