package com.teaspo.services.utils;

import com.teaspo.exceptions.NoSuchEntityException;
import com.teaspo.persistence.dao.PlaceRepository;
import com.teaspo.persistence.dao.UsersRepository;
import com.teaspo.persistence.entities.PlaceEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by mykola.dekhtiarenko on 27.12.16.
 */
@Service
public class PlaceServiceImpl implements IPlaceService {

    @Resource
    private PlaceRepository placesRepository;

    @Resource
    private UsersRepository usersRepository;

    @Override
    @Transactional
    public PlaceEntity getPlaceById(int placeId) throws NoSuchEntityException {
        PlaceEntity place = placesRepository.findOne(placeId);
        if (place == null)
            throw new NoSuchEntityException("place", "id: " + placeId);
        return place;
    }

    //TODO


}
