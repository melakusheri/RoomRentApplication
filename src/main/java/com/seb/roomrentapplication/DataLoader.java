package com.seb.roomrentapplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner{
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;

    @Override
    public void run(String... strings) throws Exception{
        roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("USER"));
        Role adminRole=roleRepository.findByRole("ADMIN");
        Role userRole =roleRepository.findByRole("USER");

        Room room1=new Room();
        room1.setAddress("5412");
        room1.setCity("Dc");
        room1.setState("Washington");
        room1.setPrice("1500.00");
        room1.setDescription("Very Nice");
        room1.setRules("No smoking");
        room1.setWifi("Wifi Availabe");
        room1.setCable("none");
        room1.setBath("private");
        roomRepository.save(room1);

        Room room2=new Room();
        room2.setAddress("3300");
        room2.setCity("VA");
        room2.setState("MD");
        room2.setPrice("500.00");
        room2.setDescription("Very Nice");
        room2.setRules("No smoking");
        room2.setWifi("Wifi Available");
        room2.setCable("none");
        room2.setBath("private");
        roomRepository.save(room2);

        Room room3=new Room();
        room3.setAddress("2525");
        room3.setCity("AT");
        room3.setState("Georgia");
        room3.setPrice("2000.00");
        room3.setDescription("Very Nice");
        room3.setRules("No smoking");
        room3.setWifi("No Wifi Access");
        room3.setCable("none");
        room3.setBath("private");
        roomRepository.save(room3);


        AppUser user=new AppUser("jim@jim.com","password","Jim","Jimmerson",true,"jim");
        userService.saveUser(user);
        room1.setAppUser(user);
        roomRepository.save(room1);

        user=new AppUser("bob@bob.com","password","Bob","Bobmerson",true,"bob");
        userService.saveUser(user);
        room2.setAppUser(user);
        room3.setAppUser(user);
        roomRepository.save(room2);
        roomRepository.save(room3);

        user=new AppUser("steve@admin.com","password","Steve","Green",true,"admin");
        userService.saveAdmin(user);




//        user=new AppUser("sam@everyman.com","password","Sam","Everyman",true,"sam");
//        userService.saveAdmin(user);
// public Room(String address, String city, String state, String price, String description, String rules, String wifi, String cable, String bath, AppUser appUser,String status)



    }
}
