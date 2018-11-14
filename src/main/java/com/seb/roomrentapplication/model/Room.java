package com.seb.roomrentapplication.model;


import com.seb.roomrentapplication.model.AppUser;

import javax.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private long roomId;

    private String address;
    private String city;
    private String state;
    private String price;
    private String description;
    private String rules;
    private String wifi;
    private String cable;
    private String bath;
    private String status;
    private String pic;

    @ManyToOne

    private AppUser appUser;

    public Room(String address, String city, String state, String price, String description, String rules, String wifi, String cable, String bath, AppUser appUser,String status,String pic) {
        this.setAddress(address);
        this.setCity(city);
        this.setState(state);
        this.setPrice(price);
        this.setDescription(description);
        this.setRules(rules);
        this.setWifi(wifi);
        this.setCable(cable);
        this.setBath(bath);
        this.setAppUser(appUser);
        this.setStatus(status);
        this.setPic(pic);
    }

    public Room() {
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long id) {
        this.roomId = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getCable() {
        return cable;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }

    public String getBath() {
        return bath;
    }

    public void setBath(String bath) {
        this.bath = bath;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
