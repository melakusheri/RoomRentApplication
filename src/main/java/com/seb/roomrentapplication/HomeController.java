package com.seb.roomrentapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoomRepository roomRepository;


    @RequestMapping("/")
    public String list(Model model){


        model.addAttribute("rooms",roomRepository.findAll());
        return "home";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/add")
    public String addAccount(Model model){

        model.addAttribute("room",new Room());

        return "roomform";
    }
    @PostMapping("/process")
    public String process(Room room,Authentication auth){

//        AppUser appUser=((CustomUserDetails)((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();
        AppUser appUser=appUserRepository.findByUserName(auth.getName());
        room.setAppUser(appUser);
        roomRepository.save(room);
        appUser.getRooms().add(room);
          return "redirect:/";
    }
    @RequestMapping("/listmyrooms")
    public String ListMyRooms(Model model, Authentication auth){
//        AppUser appUser=((CustomUserDetails)((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();
        AppUser appUser=appUserRepository.findByUserName(auth.getName());
        model.addAttribute("myRooms",roomRepository.findAllByAppUser(appUser));


        return "listmyrooms";
    }
    @RequestMapping("/detail/{roomId}")
    public String showMore(@PathVariable("roomId") long roomId, Model model){
        System.out.println(roomId);
        model.addAttribute("room", roomRepository.findById(roomId).get());

        return "showmore";
    }
    @RequestMapping("/user/update/{roomId}")
    public String updateUser(@PathVariable("roomId") long roomId, Model model){


        model.addAttribute("room", roomRepository.findById(roomId).get());

        return "roomform";
    }
    @RequestMapping("/admin/update/{roomId}")
    public String updateAdmin(@PathVariable("roomId") long roomId, Model model){


        model.addAttribute("room", roomRepository.findById(roomId).get());

        return "roomform";
    }
}
