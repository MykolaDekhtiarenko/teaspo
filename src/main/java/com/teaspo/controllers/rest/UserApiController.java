package com.teaspo.controllers.rest;

import com.teaspo.exceptions.*;
import com.teaspo.persistence.entities.RoleEntity;
import com.teaspo.persistence.entities.UserEntity;
import com.teaspo.pojo.other.Response;
import com.teaspo.services.converters.Fields;
import com.teaspo.services.utils.IUserService;
import com.teaspo.services.utils.ResponseFactory;
import com.teaspo.views.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Andrii on 15.11.2016.
 */
@Controller
@RequestMapping(value = "/api/users")
public class UserApiController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ResponseFactory responseFactory;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public
    @ResponseBody
    Response<Map<String, Object>>
    getUser(
            @PathVariable("id") int userId,
            @RequestParam(value = "fields", required = false, defaultValue = Fields.User.DEFAULT) Set<String> fields
    ) throws TeaSpoException {
        System.out.print(fields);
        return responseFactory.get(userService.getUserByIdMap(userId, fields));
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
    )
    public @ResponseBody Response<List<Map<String, Object>>>
    getUsers(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "fields", required = false, defaultValue = Fields.User.DEFAULT) Set<String> fields
    ) throws TeaSpoException {
        return responseFactory.get(userService.getUsersMap(offset, limit, fields));
    }


    @RequestMapping(
            value = "/",
            method = RequestMethod.PUT
    )
    public
    @ResponseBody Response<Integer>
    createUser(
            @RequestBody UserView view
    ) throws TeaSpoException {
        return responseFactory.get(userService.create(view));
    }


    @RequestMapping(
            value = "/sign_in",
            method = RequestMethod.POST
    )
    public
    @ResponseBody Response<Boolean>
    signIn(
            @RequestBody UserView view
    ) throws TeaSpoException {
        return responseFactory.get(userService.signInUser(view));
    }


    @RequestMapping(
            value = "/logout",
            method = RequestMethod.POST
    )
    public
    @ResponseBody Response<Boolean>
    logout(HttpServletRequest request, HttpServletResponse response){
        return responseFactory.get(userService.logoutUser(request, response));
    }


    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST
    )
    public
    @ResponseBody Response<UserEntity>
    update(@RequestBody UserView userView) throws NoSuchEntityException {
        System.out.print("Зайшло");
        return responseFactory.get(userService.update(userView));
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST
    )
    public
    @ResponseBody Response<Integer>
    create(@RequestBody UserView userView) throws NoSuchEntityException, ServiceErrorException, ValidationException, EmailExistsException {
        return responseFactory.get(userService.create(userView));
    }

    @RequestMapping(
            value = "/disable/{id}",
            method = RequestMethod.POST
    )
    public
    @ResponseBody Response<UserEntity>
    disable(@PathVariable("id") int userId) throws NoSuchEntityException, ServiceErrorException, ValidationException, EmailExistsException {
        return responseFactory.get(userService.disableUser(userId));
    }

    @RequestMapping(
            value = "/enable/{id}",
            method = RequestMethod.POST
    )
    public
    @ResponseBody Response<UserEntity>
    enable(@PathVariable("id") int userId) throws NoSuchEntityException, ServiceErrorException, ValidationException, EmailExistsException {
        return responseFactory.get(userService.enableUser(userId));
    }


}
