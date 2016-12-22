package com.teaspo.services.utils;

import com.teaspo.exceptions.*;
import com.teaspo.persistence.dao.RolesRepository;
import com.teaspo.persistence.entities.RoleEntity;



import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Brunets on 21.11.2016.
 */
@Service
public class RoleServiceImpl implements IRoleService {

	 @Resource
	 private RolesRepository rolesRepository;


	@Override
	public RoleEntity getRoleById(int roleId) throws NoSuchEntityException {
		RoleEntity role = rolesRepository.findOne(roleId);
		if (role == null)
			throw new NoSuchEntityException("role", "id: " + roleId);
		return role;
	}
}
