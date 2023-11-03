package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.Role;
import com.insurance.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role save(Role r) {
		Role role = roleRepository.save(r);
		return role;
	}

	@Override
	public void deleteRoleById(int rId) {
		roleRepository.deleteById(rId);
	}

	@Override
	public Role findByRoleId(int rId) {
		Optional<Role> r = roleRepository.findById(rId);
		if (r.isPresent()) {
			return r.get();
		} else
		return null;
	}

	@Override
	public Role findByRoleName(String roleName) {
		System.out.println("in findByRoleName in RoleServiceImpl");
		return roleRepository.findByRoleName(roleName);
	}

}
