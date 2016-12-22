package com.teaspo.services.utils;

import com.teaspo.exceptions.NoSuchEntityException;
import com.teaspo.persistence.entities.PermissionEntity;
import org.springframework.stereotype.Component;

/**
 * Created by mykola.dekhtiarenko on 19.12.16.
 */


public interface IPermissionService {
    PermissionEntity getPermissionById(int permissionId) throws NoSuchEntityException;
}
