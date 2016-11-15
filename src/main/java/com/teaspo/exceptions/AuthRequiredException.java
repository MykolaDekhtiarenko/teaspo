package com.teaspo.exceptions;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrii on 15.11.2016.
 */
public class AuthRequiredException extends TeaSpoException {

    @Override
    public int getCode(){
        return HttpServletResponse.SC_UNAUTHORIZED;
    }

    @Override
    public String formMessage() {
        return "You must be authorized!";
    }

}
