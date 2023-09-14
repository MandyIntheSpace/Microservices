package com.hotel.services.hotelmicroservices.repo;

import com.hotel.services.hotelmicroservices.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, String> {

}
