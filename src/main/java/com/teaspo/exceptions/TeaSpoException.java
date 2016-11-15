package com.teaspo.exceptions;

import org.springframework.context.MessageSource;

import java.util.List;

/**
 * Created by Andrii on 15.11.2016.
 */
public class TeaSpoException extends Exception {
    private int code;

    public TeaSpoException(){
        this("TeaSpoException");
    }

    public TeaSpoException(String message){
        super(message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * override this method to create custom messages for users
     * @return converted message
     */
    public String formMessage(){
        return getMessage();
    }

    /**
     * override this method to create a list of errors for user
     * @return list of errors
     */
    public List<String> formListErrors(MessageSource messageSource, String locale){
        return null;
    }
}
