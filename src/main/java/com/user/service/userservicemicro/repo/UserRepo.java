package com.user.service.userservicemicro.repo;

import com.user.service.userservicemicro.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UserRepo extends JpaRepository<User, Long> {

}
