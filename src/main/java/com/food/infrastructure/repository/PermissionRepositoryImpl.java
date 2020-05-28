package com.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.food.domain.model.Permission;
import com.food.domain.repository.PermissionRepository;

public class PermissionRepositoryImpl implements PermissionRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Permission> findAll() {
		return manager.createQuery("from Permission", Permission.class).getResultList();
	}

	@Override
	public Permission findById(Long id) {
		return manager.find(Permission.class, id);
	}
	
	@Transactional
	@Override
	public Permission add(Permission permission) {
		return manager.merge(permission);
	}

	@Transactional
	@Override
	public void remove(Permission permission) {
		permission = findById(permission.getId());
		manager.remove(permission);
	}

}
