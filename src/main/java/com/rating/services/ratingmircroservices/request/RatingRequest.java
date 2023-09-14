package com.rating.services.ratingmircroservices.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingRequest {

    private String userId;

    private String hotelId;

    private int ratingNumbers;

    private String feedback;
}
