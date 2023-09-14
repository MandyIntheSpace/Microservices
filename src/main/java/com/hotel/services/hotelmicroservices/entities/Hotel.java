package com.hotel.services.hotelmicroservices.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "HOTEL")
public class Hotel {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String hotelId;
    private String name;
    private String location;
    private String about;
}
