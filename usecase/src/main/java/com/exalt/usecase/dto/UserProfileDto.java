package com.exalt.usecase.dto;

import com.exalt.usecase.model.Address;

public class UserProfileDto {
    private String photoUrl;
    private Address work;
    private Address home ;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Address getWork() {
        return work;
    }

    public void setWork(Address work) {
        this.work = work;
    }

    public Address getHome() {
        return home;
    }

    public void setHome(Address home) {
        this.home = home;
    }
}
