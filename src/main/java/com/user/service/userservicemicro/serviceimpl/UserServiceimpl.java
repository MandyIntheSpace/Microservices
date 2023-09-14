package com.user.service.userservicemicro.serviceimpl;

import com.user.service.userservicemicro.entities.User;
import com.user.service.userservicemicro.exception.ResourceNotFoundException;
import com.user.service.userservicemicro.repo.UserRepo;
import com.user.service.userservicemicro.request.UserRequest;
import com.user.service.userservicemicro.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserRequest saveUser(UserRequest userRequest) {
        try{
            User user = new User();
            String randomUserId = UUID.randomUUID().toString();
            user.setUserId(randomUserId);
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setAbout(userRequest.getAbout());
            User user1 = this.userRepo.save(user);
            return this.modelMapper.map(user1, UserRequest.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<UserRequest> getAllUser() {
        List<User> user = this.userRepo.findAll();
        List<UserRequest> userRequestList = new ArrayList<>();
        for (User user1: user) {
            if (user != null) {
                UserRequest userRequest = this.modelMapper.map(user1, UserRequest.class);
                userRequestList.add(userRequest);
            }
        }
        return userRequestList;
    }

    @Override
    public UserRequest getUser(Long userId) {
        try{
            User user = this.userRepo.findById(userId).orElseThrow(() ->
                    new ResourceNotFoundException("User not found with user id"+ userId));
            return this.modelMapper.map(user, UserRequest.class);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
