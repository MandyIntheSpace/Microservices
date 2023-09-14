package com.hotel.services.hotelmicroservices.service;

import com.hotel.services.hotelmicroservices.request.HotelRequest;

import java.util.List;

public interface HotelService {
    HotelRequest createHotel(HotelRequest hotelRequest);
    List<HotelRequest> getALlHotel();
    HotelRequest getHotel(String hotelId);
}
