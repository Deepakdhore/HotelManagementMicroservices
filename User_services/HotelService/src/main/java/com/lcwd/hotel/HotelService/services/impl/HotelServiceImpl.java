package com.lcwd.hotel.HotelService.services.impl;

import com.lcwd.hotel.HotelService.entities.Hotel;
import com.lcwd.hotel.HotelService.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.HotelService.repositories.HotelRepositories;
import com.lcwd.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepositories hotelRepositories;

    @Override
    public List<Hotel> getAll() {
        return hotelRepositories.findAll();
    }

    @Override
    public Hotel get(String id) {
        Hotel user;
        user = hotelRepositories.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found"));

        return user;
    }

    public Hotel create(Hotel hotel)
    {
        String hotelId = UUID.randomUUID().toString();;
        hotel.setId(hotelId);

        return hotelRepositories.save(hotel);
    }

}
