package com.user.service.userservicemicro.request;

import com.user.service.userservicemicro.entities.Ratings;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {

    @NotBlank(message = "name cannot be left blank")
    private String name;

    @NotBlank(message = "email cannot be left blank")
    private String email;

    @NotBlank(message = "about cannot be left blank")
    private String about;

    private List<Ratings> ratingsList = new ArrayList<>();
}
