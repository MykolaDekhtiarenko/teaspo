package com.teaspo.services.utils;

import com.teaspo.exceptions.*;
import com.teaspo.persistence.entities.RoleEntity;


/**
 * Created by Brunets on 15.11.2016.
 */
public interface IRoleService {
    
    RoleEntity changeRole(RoleEntity role) throws NoSuchEntityException;
}
