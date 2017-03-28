package com.teaspo.controllers.rest;

import com.teaspo.exceptions.NoSuchEntityException;
import com.teaspo.exceptions.TeaSpoException;
import com.teaspo.persistence.entities.PermissionEntity;
import com.teaspo.persistence.entities.PlaceEntity;
import com.teaspo.pojo.other.Response;
import com.teaspo.services.converters.Fields;
import com.teaspo.services.utils.IPlaceService;
import com.teaspo.services.utils.ResponseFactory;
import com.teaspo.views.PlaceView;
import com.teaspo.views.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
    )
    public @ResponseBody Response<List<PlaceEntity>>
    getPlaces(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit
    ) throws TeaSpoException {
        return responseFactory.get(placeService.getPlaces(offset, limit));
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.PUT
    )
    public
    @ResponseBody Response<Integer>
    createPlace(
            @RequestBody PlaceView view
    ) throws TeaSpoException {
        return responseFactory.get(placeService.create(view));
    }
}
