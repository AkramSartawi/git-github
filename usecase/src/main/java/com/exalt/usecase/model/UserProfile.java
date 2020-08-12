package com.exalt.usecase.model;


import javax.persistence.*;

@Entity
@Table(name = "USERPROFILE")
public class UserProfile {
    @Id
    @Column(name = "userid")
    private Integer id;

    @Column(name = "photo")
    private String photoUrl;

    @AttributeOverrides({
            @AttributeOverride(name = "streetaddress", column = @Column(name = "streetaddresshome")),
            @AttributeOverride(name = "city", column = @Column(name = "cityhome")),
            @AttributeOverride(name = "state", column = @Column(name = "statehome")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "zipcodehome")),
            @AttributeOverride(name = "country", column = @Column(name = "countryhome"))
    })
    @Embedded
    private Address home;

    @AttributeOverrides({
            @AttributeOverride(name = "streetaddress", column = @Column(name = "streetaddresswork")),
            @AttributeOverride(name = "city", column = @Column(name = "citywork")),
            @AttributeOverride(name = "state", column = @Column(name = "statework")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "zipcodework")),
            @AttributeOverride(name = "country", column = @Column(name = "countrywork"))
    })
    @Embedded
    private Address work;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getHome() {
        return home;
    }

    public void setHome(Address home) {
        this.home = home;
    }

    public Address getWork() {
        return work;
    }

    public void setWork(Address work) {
        this.work = work;
    }
}
