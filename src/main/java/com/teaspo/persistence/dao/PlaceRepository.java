package com.teaspo.persistence.dao;

import com.teaspo.persistence.entities.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mykola.dekhtiarenko on 27.12.16.
 */

@Transactional(propagation= Propagation.REQUIRED)
public interface PlaceRepository extends JpaRepository<PlaceEntity, Integer> {

}
