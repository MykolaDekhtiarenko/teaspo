package com.teaspo.exceptions;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrii on 15.11.2016.
 */
public class ForbiddenException extends TeaSpoException{
    @Override
    public int getCode(){
        return HttpServletResponse.SC_FORBIDDEN;
    }

    @Override
    public String formMessage() {
        return "You have no permissions for this method!";
    }
}
