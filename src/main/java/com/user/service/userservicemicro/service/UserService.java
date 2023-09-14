package com.user.service.userservicemicro.service;

import com.user.service.userservicemicro.entities.User;
import com.user.service.userservicemicro.request.UserRequest;

import java.util.List;

public interface UserService {
    UserRequest saveUser(UserRequest userRequest);
    List<UserRequest> getAllUser();

    UserRequest getUser(Long userId);
}
