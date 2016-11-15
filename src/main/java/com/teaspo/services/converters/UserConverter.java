package com.teaspo.services.converters;

import com.teaspo.persistence.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.teaspo.services.converters.Fields.User.*;

/**
 * Created by Andrii on 15.11.2016.
 */
@Component
public class UserConverter extends Converter<UserEntity> {
    @Override
    public Map<String, Object> convert(UserEntity object, Set<String> fields) {
        Map<String, Object> map = new HashMap<>();
        if(fields.contains(ID))
            map.put(ID, object.getId());
        if(fields.contains(EMAIL))
            map.put(EMAIL, object.getEmail());
        if(fields.contains(NIKNAME))
            map.put(NIKNAME, object.getNikname());
        if(fields.contains(PASSWORD))
            map.put(PASSWORD, object.getPassword());
        if(fields.contains(ACTIVE))
            map.put(ACTIVE, object.isActive());
        if(fields.contains(ROLE))
            map.put(ROLE, object.getRoleEntity().getName());
        return map;
    }
}
