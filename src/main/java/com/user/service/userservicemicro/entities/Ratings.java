package com.user.service.userservicemicro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ratings {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String remarks;
}
