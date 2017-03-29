package com.teaspo.persistence.entities;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * Created by mykola.dekhtiarenko on 29.03.17.
 */
public class MeetingEntity {

    private Integer id;
    private String name;
    private String description;
    private Double latitude;
    private Double longitude;
    private Integer capacity;
    private Date datetime;

    private PlaceEntity placeEntity;

}
