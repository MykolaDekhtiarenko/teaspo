package com.teaspo.services.utils;

import com.teaspo.exceptions.NoSuchEntityException;
import com.teaspo.persistence.entities.PlaceEntity;
import com.teaspo.persistence.entities.UserEntity;

/**
 * Created by mykola.dekhtiarenko on 27.12.16.
 */
public interface IPlaceService {

    PlaceEntity getPlaceById(int placeId) throws NoSuchEntityException;

   //TODO

}
