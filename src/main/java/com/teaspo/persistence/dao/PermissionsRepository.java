package com.teaspo.persistence.dao;

import com.teaspo.persistence.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by mykola.dekhtiarenko on 19.12.16.
 */
@Transactional(propagation= Propagation.REQUIRED)
public interface PermissionsRepository extends JpaRepository<PermissionEntity, Integer> {

}
