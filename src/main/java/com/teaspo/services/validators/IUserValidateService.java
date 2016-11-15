package com.teaspo.services.validators;

import com.teaspo.exceptions.ServiceErrorException;
import com.teaspo.exceptions.ValidationException;
import com.teaspo.views.UserView;

/**
 * Created by Andrii on 15.11.2016.
 */
public interface IUserValidateService {
    void validForCreate(UserView user) throws ServiceErrorException, ValidationException;
}
