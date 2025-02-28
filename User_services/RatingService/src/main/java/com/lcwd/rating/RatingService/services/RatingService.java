package com.lcwd.rating.RatingService.services;

import com.lcwd.rating.RatingService.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    //create
    Rating createRating(Rating Rating);

    //get all ratings
    List<Rating> getAllRating();

    //get rating by id
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByHotelId(String HotelId);

}