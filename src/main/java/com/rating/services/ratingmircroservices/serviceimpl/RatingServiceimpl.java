package com.rating.services.ratingmircroservices.serviceimpl;

import com.rating.services.ratingmircroservices.entities.Ratings;
import com.rating.services.ratingmircroservices.repositories.RatingRepo;
import com.rating.services.ratingmircroservices.request.RatingRequest;
import com.rating.services.ratingmircroservices.services.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceimpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RatingRequest createRatings(RatingRequest ratingRequest) {
        Ratings ratings = new Ratings();
        String randomRatingId = UUID.randomUUID().toString();
        ratings.setRatingId(randomRatingId);
        ratings.setFeedback(ratingRequest.getFeedback());
        ratings.setRatingNumbers(ratingRequest.getRatingNumbers());
        ratings.setUserId(ratingRequest.getUserId());
        ratings.setHotelId(ratingRequest.getHotelId());
        Ratings ratings1 = this.ratingRepo.save(ratings);
        return this.modelMapper.map(ratings1, RatingRequest.class);
    }

    @Override
    public List<RatingRequest> getAllRatings() {
        List<Ratings> ratingsList = this.ratingRepo.findAll();
        List<RatingRequest> ratingRequestList = new ArrayList<>();
        if (ratingRequestList != null) {
            for (Ratings ratings: ratingsList) {
                RatingRequest ratingRequest = this.modelMapper.map(ratings, RatingRequest.class);
                ratingRequestList.add(ratingRequest);
            }
        }
        return ratingRequestList;
}

    @Override
    public List<RatingRequest> getRatingsByUser(String userId) {
        List<Ratings> ratings = this.ratingRepo.findByUserId(userId);
        List<RatingRequest> ratingRequestList = new ArrayList<>();
        if (ratings != null) {
            for (Ratings ratings1: ratings) {
                RatingRequest ratingRequest = this.modelMapper.map(ratings1, RatingRequest.class);
                ratingRequestList.add(ratingRequest);
            }
        }
        return ratingRequestList;
    }

    @Override
    public List<RatingRequest> getRatingsByHotel(String hotelId) {
        List<Ratings> ratings = this.ratingRepo.findByHotelId(hotelId);
        List<RatingRequest> ratingRequestList = new ArrayList<>();
        if (ratings != null) {
            for (Ratings ratings1: ratings) {
                RatingRequest ratingRequest = this.modelMapper.map(ratings1, RatingRequest.class);
                ratingRequestList.add(ratingRequest);
            }
        }
        System.out.println(ratingRequestList);
        return ratingRequestList;
    }
}
