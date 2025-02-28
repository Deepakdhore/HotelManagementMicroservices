package com.lcwd.rating.RatingService.controllers;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService service;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRating()
    {
        return ResponseEntity.ok(service.getAllRating());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId)
    {
        return ResponseEntity.ok(service.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingBYHotelId(@PathVariable String HotelId)
    {
        return ResponseEntity.ok(service.getRatingByHotelId(HotelId));
    }
}
