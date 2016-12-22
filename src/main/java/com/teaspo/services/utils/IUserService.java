package com.teaspo.services.utils;

import com.teaspo.exceptions.*;
import com.teaspo.persistence.entities.UserEntity;
import com.teaspo.views.UserView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Andrii on 15.11.2016.
 */
public interface IUserService {

    UserEntity getUserById(int userId) throws NoSuchEntityException;

    Map<String, Object> getUserByIdMap(int userId, Set<String> fields) throws NoSuchEntityException;

    List<UserEntity> getUsers(int offset, int limit) throws NoSuchEntityException;

    List<Map<String, Object>> getUsersMap(int offset, int limit, Set<String> fields) throws NoSuchEntityException;

    UserEntity getByEmail(String email) throws NoSuchEntityException;

    int create(UserView view) throws EmailExistsException, ServiceErrorException, ValidationException;

    Boolean update(UserView user) throws NoSuchEntityException;

    boolean signInUser(UserView view) throws NoSuchEntityException, WrongPasswordException;

    boolean logoutUser(HttpServletRequest request, HttpServletResponse response);

    boolean disableUser(int userId) throws NoSuchEntityException;

}
