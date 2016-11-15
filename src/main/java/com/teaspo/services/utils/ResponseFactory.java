package com.teaspo.services.utils;

import com.teaspo.pojo.other.Response;
import org.springframework.stereotype.Component;

/**
 * Created by Andrii on 15.11.2016.
 */
@Component
public class ResponseFactory {

    public <T> Response<T> get(T t){
        Response<T> response = new Response<T>();
        response.setResult(t);
        return response;
    }

}
