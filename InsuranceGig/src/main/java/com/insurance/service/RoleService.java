package com.insurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.domain.Role;

@Service
public interface RoleService {
	
	public List<Role> findAll();
	public Role save(Role r);
	public void deleteRoleById(int rId);
	public Role findByRoleId(int rId);
	public Role findByRoleName(String roleName);
}
