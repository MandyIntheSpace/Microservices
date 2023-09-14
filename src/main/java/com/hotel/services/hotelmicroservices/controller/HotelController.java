package com.hotel.services.hotelmicroservices.controller;

import com.hotel.services.hotelmicroservices.request.HotelRequest;
import com.hotel.services.hotelmicroservices.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<HotelRequest> createHotel(@RequestBody HotelRequest hotelRequest) {
        HotelRequest hotelRequest1 = this.hotelService.createHotel(hotelRequest);
        return new ResponseEntity<HotelRequest>(hotelRequest1,HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<HotelRequest>> getALlHotel() {
        List<HotelRequest> hotelRequest = this.hotelService.getALlHotel();
        return new ResponseEntity<List<HotelRequest>>(hotelRequest, HttpStatus.FOUND);
    }

    @GetMapping("/get/{hotelId}")
    public ResponseEntity<HotelRequest> getHotel(@PathVariable("hotelId") String hotelId) {
        HotelRequest hotelRequest = this.hotelService.getHotel(hotelId);
        return new ResponseEntity<HotelRequest>(hotelRequest, HttpStatus.FOUND);
    }
}
