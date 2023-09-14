package com.rating.services.ratingmircroservices.services;


import com.rating.services.ratingmircroservices.request.RatingRequest;

import java.util.List;

public interface RatingService {

    RatingRequest createRatings(RatingRequest ratingRequest);
    List<RatingRequest> getAllRatings();
    List<RatingRequest> getRatingsByUser(String userId);
    List<RatingRequest> getRatingsByHotel(String hotelId);


}
