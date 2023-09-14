package com.hotel.services.hotelmicroservices.serviceimpl;

import com.hotel.services.hotelmicroservices.entities.Hotel;
import com.hotel.services.hotelmicroservices.exception.ResourceNotFoundException;
import com.hotel.services.hotelmicroservices.repo.HotelRepo;
import com.hotel.services.hotelmicroservices.request.HotelRequest;
import com.hotel.services.hotelmicroservices.service.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceimpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HotelRequest createHotel(HotelRequest hotelRequest) {
        Hotel hotel = this.modelMapper.map(hotelRequest, Hotel.class);
        String randomHotelId = UUID.randomUUID().toString();
        hotel.setHotelId(randomHotelId);
        hotel.setName(hotelRequest.getName());
        hotel.setLocation(hotelRequest.getLocation());
        hotel.setAbout(hotelRequest.getAbout());
        Hotel hotel1 = this.hotelRepo.save(hotel);
        return this.modelMapper.map(hotel1, HotelRequest.class);
    }

    @Override
    public List<HotelRequest> getALlHotel() {
        List<Hotel> hotel = this.hotelRepo.findAll();
        List<HotelRequest> hotelRequestList = new ArrayList<>();
        if (hotel != null) {
            for (Hotel hotel1: hotel) {
                HotelRequest hotelRequest = this.modelMapper.map(hotel1, HotelRequest.class);
                hotelRequestList.add(hotelRequest);
            }
        }
        return hotelRequestList;
    }

    @Override
    public HotelRequest getHotel(String hotelId) {
        Hotel hotel = this.hotelRepo.findById(hotelId).orElseThrow(() ->
                new ResourceNotFoundException("The resource with the hotelId not found"+hotelId));
        if (hotel != null) {
            return this.modelMapper.map(hotel, HotelRequest.class);
        }
        return null;
    }
}
