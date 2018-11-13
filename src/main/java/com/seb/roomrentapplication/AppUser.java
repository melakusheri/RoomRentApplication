package com.seb.roomrentapplication;

import org.hibernate.annotations.ManyToAny;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
//@Table(name="User_Data")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name ="password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "username")
    private String userName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name ="role_id"))
    private List<Role> roles;

    @OneToMany(mappedBy = "appUser")
    private List<Room> rooms;

    public AppUser(String email, String password, String firstName, String lastName, boolean enabled, String userName) {
        this.setEmail(email);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEnabled(enabled);
        this.setUserName(userName);

    }


    public AppUser() {
        roles=new ArrayList<>();
        rooms=new ArrayList<>();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long id) {
        this.userId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passsword) {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(passsword);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
