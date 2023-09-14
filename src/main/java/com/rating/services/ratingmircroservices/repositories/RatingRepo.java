package com.rating.services.ratingmircroservices.repositories;

import com.rating.services.ratingmircroservices.entities.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepo extends MongoRepository <Ratings, String> {
    List<Ratings> findByUserId(String userId);
    List<Ratings> findByHotelId(String hotelId);
}
