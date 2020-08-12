package com.exalt.usecase.dto;

import java.util.Date;

public class LocationDto {
    private int lang;
    private int lat;
    private Date creationDate;

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

    public Date getCreationDate() {
        return creationDate;
    }
}
