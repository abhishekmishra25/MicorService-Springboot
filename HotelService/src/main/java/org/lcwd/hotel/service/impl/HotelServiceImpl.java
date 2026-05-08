package org.lcwd.hotel.service.impl;

import org.lcwd.hotel.entity.Hotel;
import org.lcwd.hotel.exception.ResourceNotFoundException;
import org.lcwd.hotel.reposotories.HotelRepo;
import org.lcwd.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel create(Hotel hotel) {
        hotel.setId(UUID.randomUUID().toString());
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepo.findById(id).orElseThrow( () -> new ResourceNotFoundException("Resource not found on the server for the id : " + id));
    }
}
