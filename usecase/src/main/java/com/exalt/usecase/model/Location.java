package com.exalt.usecase.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locationid")
    private int id ;

    private int lang;

    private int lat;

    @Column(name = "creationdate")
    @Temporal(value = TemporalType.DATE)
    private Date creationDate =new Date() ;

    @ManyToOne
    @JoinColumn(name = "deviceid", referencedColumnName = "deviceid")
    private Device device ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", lang=" + lang +
                ", lat=" + lat +
                ", creationDate=" + creationDate +
                '}';
    }
}
