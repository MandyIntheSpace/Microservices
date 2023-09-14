package com.hotel.services.hotelmicroservices.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelRequest {

    @NotBlank(message = "name must be specified")
    private String name;

    @NotBlank(message = "location must be specified")
    private String location;

    @NotBlank(message = "about must be specified")
    private String about;
}
