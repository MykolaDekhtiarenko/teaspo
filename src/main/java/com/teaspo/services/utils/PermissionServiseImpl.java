package com.teaspo.services.utils;

import com.teaspo.exceptions.NoSuchEntityException;
import com.teaspo.persistence.dao.PermissionsRepository;
import com.teaspo.persistence.entities.PermissionEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by mykola.dekhtiarenko on 19.12.16.
 */
@Component
public class PermissionServiseImpl implements  IPermissionService{

    @Resource
    PermissionsRepository permissionsRepository;

    @Override
    @Transactional
    public PermissionEntity getPermissionById(int permissionId) throws NoSuchEntityException {
        PermissionEntity permission = permissionsRepository.findOne(permissionId);
        if (permission == null)
            throw new NoSuchEntityException("permission", "id: " + permissionId);
        return permission;
    }
}
