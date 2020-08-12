package com.exalt.usecase.dto;


import java.util.Set;

public class UserDto {
    private int id;
    private String name;
    private String password;
    private String email;
    private UserProfileDto userProfile;
    private Set<DeviceDto> devices;
    private Set<RoleDto> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<DeviceDto> getDevices() {
        return devices;
    }

    public void setDevices(Set<DeviceDto> devices) {
        this.devices = devices;
    }

    public UserProfileDto getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileDto userProfile) {
        this.userProfile = userProfile;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }
}
