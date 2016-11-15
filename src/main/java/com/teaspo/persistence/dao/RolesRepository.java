package com.teaspo.persistence.dao;

import com.teaspo.pojo.enams.RolesEnum;
import com.teaspo.persistence.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Andrii on 15.11.2016.
 */
@Transactional(propagation= Propagation.REQUIRED)
public interface RolesRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByName(RolesEnum name);
}
