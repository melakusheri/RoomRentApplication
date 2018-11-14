package com.seb.roomrentapplication.repository;

import com.seb.roomrentapplication.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser,Long>{
    AppUser findByUserName(String username);
    AppUser findByEmail(String email);
    AppUser findByUserId(String userId);
    Long countByEmail(String email);
    Long countByUserName(String Username);
}
