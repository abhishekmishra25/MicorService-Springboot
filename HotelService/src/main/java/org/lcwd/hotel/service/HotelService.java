package org.lcwd.hotel.service;

import org.lcwd.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

    // create

    Hotel create(Hotel hotel);


    // getAll
    List<Hotel> getAll();

    // getSingle
    Hotel get(String id);
}
