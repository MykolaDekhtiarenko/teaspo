package com.teaspo.controllers.rest;

import com.teaspo.exceptions.NoSuchEntityException;
import com.teaspo.persistence.entities.PermissionEntity;
import com.teaspo.persistence.entities.PlaceEntity;
import com.teaspo.pojo.other.Response;
import com.teaspo.services.utils.IPlaceService;
import com.teaspo.services.utils.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mykola.dekhtiarenko on 27.12.16.
 */

@Controller
@RequestMapping(value = "/api/places")
public class PlaceApiController {

    @Autowired
    private IPlaceService placeService;

    @Autowired
    private ResponseFactory responseFactory;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Response<PlaceEntity>
    getPlace(@PathVariable("id") int placeId)
            throws NoSuchEntityException {
        return responseFactory.get(placeService.getPlaceById(placeId));
    }

}
