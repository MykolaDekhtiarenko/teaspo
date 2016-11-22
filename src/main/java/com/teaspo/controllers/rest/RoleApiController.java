package com.teaspo.controllers.rest;

import com.teaspo.exceptions.NoSuchEntityException;
import com.teaspo.persistence.entities.RoleEntity;
import com.teaspo.pojo.other.Response;
import com.teaspo.services.utils.IRoleService;
import com.teaspo.services.utils.ResponseFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



/**
 * Created by Brunets on 20.11.2016.
 */
@Controller
@RequestMapping(value = "/api/roles")
public class RoleApiController {

    @Autowired
    private IRoleService roleService;
    
    @Autowired
    private ResponseFactory responseFactory;

    @RequestMapping(
            value = "/",
            method = RequestMethod.PUT
    )
    public
    @ResponseBody
    Response<RoleEntity>
    changeRole(RoleEntity role) throws NoSuchEntityException{ 
    	return responseFactory.get(roleService.changeRole(role));
    }
}
