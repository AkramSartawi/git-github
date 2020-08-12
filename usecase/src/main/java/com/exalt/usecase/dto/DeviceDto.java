package com.exalt.usecase.dto;

import java.util.Set;

public class DeviceDto {
    private int id ;
    private String macAddress ;
    private Set<LocationDto> locations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Set<LocationDto> getLocations() {
        return locations;
    }

    public void setLocations(Set<LocationDto> locations) {
        this.locations = locations;
    }
}
