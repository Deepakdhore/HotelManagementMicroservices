package com.lcwd.rating.RatingService.services.impl;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.repository.RatingRepositiory;
import com.lcwd.rating.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepositiory ratingRepositiory;

    @Override
    public Rating createRating(Rating Rating) {
        return ratingRepositiory.save(Rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepositiory.findAll();
    }


    @Override
    public List<Rating> getRatingByUserId(String UserId) {
        return ratingRepositiory.findByUserId(UserId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String HotelId) {
        return ratingRepositiory.findByHotelId(HotelId);
    }
}
