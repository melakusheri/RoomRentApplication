package com.seb.roomrentapplication.service;


import com.seb.roomrentapplication.model.AppUser;
import com.seb.roomrentapplication.model.Role;
import com.seb.roomrentapplication.repository.AppUserRepository;
import com.seb.roomrentapplication.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    RoleRepository roleRepository;

    public void saveUser(AppUser appUser) {
        Role role = roleRepository.findByRole("USER");
        appUser.setRoles(Arrays.asList(role));
        appUserRepository.save(appUser);

    }
    public void saveAdmin(AppUser appUser) {
        Role role = roleRepository.findByRole("ADMIN");
        appUser.setRoles(Arrays.asList(role));
        appUserRepository.save(appUser);

    }
}
