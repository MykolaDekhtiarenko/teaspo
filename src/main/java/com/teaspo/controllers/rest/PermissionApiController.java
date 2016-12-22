package com.teaspo.controllers.rest;

import com.teaspo.exceptions.NoSuchEntityException;
import com.teaspo.persistence.entities.PermissionEntity;
import com.teaspo.pojo.other.Response;
import com.teaspo.services.utils.IPermissionService;
import com.teaspo.services.utils.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mykola.dekhtiarenko on 19.12.16.
 */
@Controller
@RequestMapping(value = "/api/permissions")
public class PermissionApiController {

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private ResponseFactory responseFactory;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Response<PermissionEntity>
    getRole(@PathVariable("id") int permissionId)
            throws NoSuchEntityException {
        return responseFactory.get(permissionService.getPermissionById(permissionId));
    }

}
