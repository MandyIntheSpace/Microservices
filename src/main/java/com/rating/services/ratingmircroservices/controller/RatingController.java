package com.rating.services.ratingmircroservices.controller;

import com.rating.services.ratingmircroservices.repositories.RatingRepo;
import com.rating.services.ratingmircroservices.request.RatingRequest;
import com.rating.services.ratingmircroservices.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/save")
    public ResponseEntity<RatingRequest> createRating(@RequestBody RatingRequest ratingRequest) {
        RatingRequest ratingRequest1 = this.ratingService.createRatings(ratingRequest);
        return new ResponseEntity<RatingRequest>(ratingRequest1, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<RatingRequest>> getAllRatings() {
        List<RatingRequest> request = this.ratingService.getAllRatings();
        return new ResponseEntity<List<RatingRequest>>(request, HttpStatus.FOUND);
    }

    @GetMapping("/get/user/{userId}")
    public ResponseEntity<List<RatingRequest>> getRatingsByUserId(@PathVariable("userId") String userId) {
        List<RatingRequest> ratingRequest = this.ratingService.getRatingsByUser(userId);
        return new ResponseEntity<List<RatingRequest>>(ratingRequest, HttpStatus.FOUND);
    }

    @GetMapping("/get/hotel/{hotelId}")
    public ResponseEntity<List<RatingRequest>> getRatingByHotelId(@PathVariable("hotelId") String hotelId) {
        List<RatingRequest> ratingRequestList = this.ratingService.getRatingsByHotel(hotelId);
        return new ResponseEntity<List<RatingRequest>>(ratingRequestList, HttpStatus.FOUND);
    }

}
