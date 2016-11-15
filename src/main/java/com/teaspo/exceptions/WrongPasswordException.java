package com.teaspo.exceptions;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrii on 15.11.2016.
 */
public class WrongPasswordException  extends TeaSpoException{
    public WrongPasswordException(){
        super("Wrong password");
    }

    @Override
    public int getCode() {
        return HttpServletResponse.SC_BAD_REQUEST;
    }
}
