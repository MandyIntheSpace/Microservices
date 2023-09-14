package com.rating.services.ratingmircroservices.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document("user_ratings")
public class Ratings {

    @Id
    private String ratingId;

    private String userId;

    private String hotelId;

    private int ratingNumbers;

    private String feedback;

}
