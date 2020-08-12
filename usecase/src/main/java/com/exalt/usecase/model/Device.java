package com.exalt.usecase.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DEVICE")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deviceid")
    private int id ;

    @Column(name = "macaddress")
    private String macAddress ;

    @ManyToOne
    @JoinColumn(name = "userid" ,referencedColumnName = "userid")
    private User user ;

    @OneToMany(mappedBy = "device" ,cascade = CascadeType.PERSIST)
    private Set<Location> locations;

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

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", macAddress='" + macAddress + '\'' +
                '}';
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
